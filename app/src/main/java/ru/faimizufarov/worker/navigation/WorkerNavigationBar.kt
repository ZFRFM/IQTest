package ru.faimizufarov.worker.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun WorkerNavigationBar(navController: NavController) {
    val navigationBarItems = listOf(
        BottomNavItem.MainScreen,
        BottomNavItem.VacancyScreen,
        BottomNavItem.HiringScreen,
        BottomNavItem.MeetingScreen
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navigationBarItems.forEach { item ->
            val isSelected = currentRoute == item.screenRoute
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(item.icon),
                        contentDescription = stringResource(id = item.title),
                        tint = if (isSelected) Color(0xFFFF9025) else Color(0xFF444748),
                        modifier = Modifier.padding(4.dp)
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = item.title),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                },
                selected = isSelected,
                onClick = {
                    navController.navigate(item.screenRoute) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination
                        // when re-selecting the same item
                        launchSingleTop = true
                        // Restore state when re-selecting a previously selected item
                        restoreState = true
                    }
                },
                modifier = Modifier.background(Color.White)
            )
        }
    }
}