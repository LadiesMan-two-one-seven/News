package com.asanagaev.news.domain.usecase

import com.asanagaev.news.domain.repository.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class AddSubscriptionsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
){

    suspend operator fun invoke(topic: String) {
        newsRepository.addSubscription(topic)
        CoroutineScope(currentCoroutineContext()).launch {
            newsRepository.updateArticlesForTopic(topic)
        }
    }
}