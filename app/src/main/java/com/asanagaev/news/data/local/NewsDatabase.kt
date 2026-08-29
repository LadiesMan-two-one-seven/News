package com.asanagaev.news.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ArticleDbModel::class, SubscriptionDbModel::class],
    version = 4,
    exportSchema = false
)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
}