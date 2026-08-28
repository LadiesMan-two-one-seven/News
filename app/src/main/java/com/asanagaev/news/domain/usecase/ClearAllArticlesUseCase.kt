package com.asanagaev.news.domain.usecase

import com.asanagaev.news.domain.entity.Article
import com.asanagaev.news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ClearAllArticlesUseCase @Inject constructor(
    private val newsRepository: NewsRepository
){

    suspend operator fun invoke(topics: List<String>) {
        return newsRepository.clearAllArticles(topics)
    }
}