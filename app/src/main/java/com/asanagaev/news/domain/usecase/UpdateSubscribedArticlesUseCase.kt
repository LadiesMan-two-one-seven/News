package com.asanagaev.news.domain.usecase

import com.asanagaev.news.domain.repository.NewsRepository
import javax.inject.Inject

class UpdateSubscribedArticlesUseCase @Inject constructor(
    private val newsRepository: NewsRepository
){

    suspend operator fun invoke() = newsRepository.updateArticlesForAllSubscriptions()
}