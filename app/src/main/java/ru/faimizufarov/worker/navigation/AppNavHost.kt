package ru.faimizufarov.worker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import ru.faimizufarov.worker.vacancy.EmptyScreen
import ru.faimizufarov.worker.vacancy.screens.FiltersScreen
import ru.faimizufarov.worker.vacancy.screens.VacancyScreen

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = NavItems.BOTTOM_GRAPH,
        route = NavItems.MAIN_GRAPH,
        modifier = Modifier
    ) {
        navigation(
            startDestination = BottomNavItem.VacancyScreen.screenRoute,
            route = NavItems.BOTTOM_GRAPH
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

        composable(NavItems.FILTERS) { FiltersScreen() }
    }
}