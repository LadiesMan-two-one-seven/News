package com.asanagaev.news.domain.entity

class RefreshConfig(
    val language: Language,
    val interval: Interval,
    val wifiOnly: Boolean
)