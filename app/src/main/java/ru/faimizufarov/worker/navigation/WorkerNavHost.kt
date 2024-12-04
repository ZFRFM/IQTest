package ru.faimizufarov.worker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.faimizufarov.worker.vacancy.EmptyScreen
import ru.faimizufarov.worker.vacancy.screens.VacancyScreen

@Composable
fun WorkerNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.VacancyScreen.screenRoute,
        modifier = modifier
    ) {
        composable(BottomNavItem.MainScreen.screenRoute) {
            EmptyScreen()
        }

        composable(BottomNavItem.VacancyScreen.screenRoute) {
            VacancyScreen()
        }

        composable(BottomNavItem.HiringScreen.screenRoute) {
            EmptyScreen()
        }

        composable(BottomNavItem.MeetingScreen.screenRoute) {
            EmptyScreen()
        }
    }
}