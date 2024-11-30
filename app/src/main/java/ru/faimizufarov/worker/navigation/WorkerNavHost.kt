package ru.faimizufarov.worker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.faimizufarov.hiring.HiringScreen
import ru.faimizufarov.main.MainScreen
import ru.faimizufarov.meeting.MeetingScreen
import ru.faimizufarov.vacancy.screens.VacancyScreen

@Composable
fun WorkerNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.VacancyScreen.screenRoute,
        modifier = modifier
    ) {
        composable(BottomNavItem.MainScreen.screenRoute) {
            MainScreen()
        }

        composable(BottomNavItem.VacancyScreen.screenRoute) {
            VacancyScreen()
        }

        composable(BottomNavItem.HiringScreen.screenRoute) {
            HiringScreen()
        }

        composable(BottomNavItem.MeetingScreen.screenRoute) {
            MeetingScreen()
        }
    }
}