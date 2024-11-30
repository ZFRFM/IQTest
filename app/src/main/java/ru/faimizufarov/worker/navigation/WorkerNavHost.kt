package ru.faimizufarov.worker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun WorkerNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.VacancyScreen.screenRoute,
        modifier = modifier
    ) {
        composable(BottomNavItem.MainScreen.screenRoute) {
            TODO("Main screen")
        }

        composable(BottomNavItem.VacancyScreen.screenRoute) {
            TODO("Vacancy screen")
        }

        composable(BottomNavItem.HiringScreen.screenRoute) {
            TODO("Hiring screen")
        }

        composable(BottomNavItem.MeetingScreen.screenRoute) {
            TODO("Meeting screen")
        }
    }
}