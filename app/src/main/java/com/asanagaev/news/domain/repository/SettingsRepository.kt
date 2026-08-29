package com.asanagaev.news.domain.repository

import com.asanagaev.news.domain.entity.Language
import com.asanagaev.news.domain.entity.Settings
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    fun getSettings(): Flow<Settings>

    suspend fun updateLanguage(language: Language)

    suspend fun updateInterval(minutes: Int)

    suspend fun updateNotificationsEnabled(enabled: Boolean)

    suspend fun updateWifiOnly(wifiOnly: Boolean)
}