package com.asanagaev.news.data.repository

import com.asanagaev.news.data.local.ArticleDbModel
import com.asanagaev.news.data.local.NewsDao
import com.asanagaev.news.data.local.SubscriptionDbModel
import com.asanagaev.news.data.mapper.toDbModels
import com.asanagaev.news.data.mapper.toEntities
import com.asanagaev.news.data.remote.NewsApiService
import com.asanagaev.news.domain.entity.Article
import com.asanagaev.news.domain.repository.NewsRepository
import javax.inject.Inject
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class NewsRepositoryImpl @Inject constructor(
    private val newsDao: NewsDao,
    private val newsApiService: NewsApiService
) : NewsRepository {
    override fun getAllSubscriptions(): Flow<List<String>> {
        return newsDao.getAllSubscriptions().map { subscriptions ->
            subscriptions.map { it.topic }
        }
    }

    override suspend fun addSubscription(topic: String) {
        newsDao.addSubscription(SubscriptionDbModel(topic))
    }

    override suspend fun updateArticlesForTopic(topic: String) {
        val articles = loadArticles(topic)
        newsDao.addArticles(articles)
    }

    private suspend fun loadArticles(topic: String): List<ArticleDbModel> {
        return try {
            newsApiService.loadArticles(topic).toDbModels(topic)
                .filter { isEnglish(it.title) }
        } catch (e: Exception) {
            if (e is CancellationException) {
                throw e
            }
            listOf()
        }
    }

    private fun isEnglish(text: String?): Boolean {
        if (text.isNullOrBlank()) return false
        val letters = text.filter { it.isLetter() }
        if (letters.isEmpty()) return false
        val latinLetters = letters.count { it in 'a'..'z' || it in 'A'..'Z' }
        return latinLetters.toFloat() / letters.length >= 0.7f
    }

    override suspend fun removeSubscription(topic: String) {
        newsDao.deleteSubscription(SubscriptionDbModel(topic))
    }

    override suspend fun updateArticlesForAllSubscriptions() {
        val subscriptions = newsDao.getAllSubscriptions().first()
        coroutineScope {
            subscriptions.forEach {
                launch {
                    updateArticlesForTopic(it.topic)
                }
            }
        }
    }

    override fun getArticlesByTopics(topics: List<String>): Flow<List<Article>> {
        return newsDao.getAllArticlesByTopics(topics).map {
            it.toEntities()
        }
    }

    override suspend fun clearAllArticles(topics: List<String>) {
        newsDao.deleteArticlesByTopics(topics)
    }
}