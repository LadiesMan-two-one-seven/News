package com.asanagaev.news.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/everything?apiKey=ae026f091a0a44979c8f3cb38d1777c6")
    suspend fun loadArticles(
        @Query("q") topic: String
    ): NewsResponseDto
}