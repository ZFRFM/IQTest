package ru.faimizufarov.worker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.faimizufarov.worker.vacancy.EmptyScreen
import ru.faimizufarov.worker.vacancy.screens.VacancyScreen

@Composable
fun BottomNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.VacancyScreen.screenRoute,
        modifier = Modifier
    ) {
        composable(BottomNavItem.MainScreen.screenRoute) {
            EmptyScreen()
        }

        composable(BottomNavItem.VacancyScreen.screenRoute) {
            VacancyScreen(navController)
        }

        composable(BottomNavItem.HiringScreen.screenRoute) {
            EmptyScreen()
        }

        composable(BottomNavItem.MeetingScreen.screenRoute) {
            EmptyScreen()
        }
    }
}