package com.asanagaev.news.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.asanagaev.news.presentation.screen.settings.SettingsScreen
import com.asanagaev.news.presentation.screen.subscriptions.SubscriptionScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Subscriptions.route
    ) {
        composable(Screen.Subscriptions.route) {
            SubscriptionScreen(
                onNavigateToSettings = {
                    navController.navigate(Screen.Settings.route)
                }
            )
        }

        composable(Screen.Settings.route) {
            SettingsScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

sealed class Screen(val route: String) {

    data object Subscriptions: Screen("subscriptions")
    data object Settings: Screen("settings")
}