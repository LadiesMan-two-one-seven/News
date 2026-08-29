package com.asanagaev.news.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.asanagaev.news.presentation.screen.subscriptions.SubscriptionScreen
import com.asanagaev.news.presentation.ui.theme.NewsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsTheme {
                SubscriptionScreen(
                    onNavigateToSettings = {}
                )
            }
        }
    }
}
