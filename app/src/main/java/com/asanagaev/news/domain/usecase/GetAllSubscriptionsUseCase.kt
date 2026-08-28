package com.asanagaev.news.domain.usecase

import com.asanagaev.news.domain.repository.NewsRepository
import javax.inject.Inject

class GetAllSubscriptionsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
){

    operator fun invoke() = newsRepository.getAllSubscriptions()
}