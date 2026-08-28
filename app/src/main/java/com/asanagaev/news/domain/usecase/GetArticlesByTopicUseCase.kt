package com.asanagaev.news.domain.usecase

import com.asanagaev.news.domain.entity.Article
import com.asanagaev.news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetArticlesByTopicUseCase @Inject constructor(
    private val newsRepository: NewsRepository
){

    operator fun invoke(topics: List<String>): Flow<List<Article>> {
        return newsRepository.getArticlesByTopics(topics)
    }
}