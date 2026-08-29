package com.asanagaev.news.data.mapper

import com.asanagaev.news.domain.entity.RefreshConfig
import com.asanagaev.news.domain.entity.Settings

fun Settings.toRefreshConfig(): RefreshConfig{
    return RefreshConfig(language, interval, wifiOnly)
}