package com.asanagaev.news.domain.usecase

import com.asanagaev.news.domain.entity.Interval
import com.asanagaev.news.domain.entity.Language
import com.asanagaev.news.domain.repository.SettingsRepository
import javax.inject.Inject

class UpdateLanguageUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {

    suspend operator fun invoke(language: Language) {
        settingsRepository.updateLanguage(language)
    }
}