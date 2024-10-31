package com.resuadam2.watchlistapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.resuadam2.watchlistapp.ui.screens.FormItemScreen
import com.resuadam2.watchlistapp.ui.screens.MainScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.MAIN.name) {
        composable(AppScreens.MAIN.name) {
            MainScreen(
                navigateToForm = { navController.navigate(AppScreens.FORM_ITEM.name) }
            )
        }
        composable(AppScreens.FORM_ITEM.name) {
            FormItemScreen(
                navigateBack = { navController.popBackStack() }
            )
        }
    }
    
}