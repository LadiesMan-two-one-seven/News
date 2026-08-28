package com.asanagaev.news.domain.usecase

import com.asanagaev.news.domain.repository.NewsRepository
import javax.inject.Inject

class RemoveSubscriptionsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
){

    suspend operator fun invoke(topic: String) = newsRepository.removeSubscription(topic)
}