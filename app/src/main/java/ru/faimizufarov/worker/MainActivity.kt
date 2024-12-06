package ru.faimizufarov.worker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.faimizufarov.worker.navigation.AppNavHost
import ru.faimizufarov.worker.navigation.WorkerNavigationBar
import ru.faimizufarov.worker.theme.WorkerTheme
import ru.faimizufarov.worker.vacancy.components.VacancyFloatingActionButton
import ru.faimizufarov.worker.vacancy.components.VacancyTopAppBar
import ru.faimizufarov.worker.navigation.BottomNavItem
import ru.faimizufarov.worker.navigation.NavItems
import ru.faimizufarov.worker.vacancy.components.FiltersTopAppBar

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorkerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val currentRoute = navController
                        .currentBackStackEntryAsState()
                        .value
                        ?.destination
                        ?.route

                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            when (currentRoute) {
                                BottomNavItem.VacancyScreen.screenRoute -> VacancyTopAppBar()
                                NavItems.FILTERS -> FiltersTopAppBar { navController.popBackStack() }
                            }
                        },
                        floatingActionButton = {
                            if (currentRoute == BottomNavItem.VacancyScreen.screenRoute) {
                                VacancyFloatingActionButton()
                            }
                        },
                        bottomBar = {
                            if (
                                currentRoute == BottomNavItem.MainScreen.screenRoute ||
                                currentRoute == BottomNavItem.VacancyScreen.screenRoute ||
                                currentRoute == BottomNavItem.HiringScreen.screenRoute ||
                                currentRoute == BottomNavItem.MeetingScreen.screenRoute
                            ) WorkerNavigationBar(navController = navController)
                        }
                    ) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            AppNavHost(navController)
                        }
                    }
                }
            }
        }
    }
}