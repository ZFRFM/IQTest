package ru.faimizufarov.worker.navigation

import ru.faimizufarov.worker.R

sealed class BottomNavItem(var title: Int, var icon: Int, var screenRoute: String) {
    data object MainScreen: BottomNavItem(
        R.string.main,
        R.drawable.main_icon,
        "main_screen"
    )
    data object VacancyScreen: BottomNavItem(
        R.string.vacancy,
        R.drawable.vacancy_icon,
        "vacancy_screen"
    )
    data object HiringScreen: BottomNavItem(
        R.string.hiring,
        R.drawable.hiring_icon,
        "hiring_screen"
    )
    data object MeetingScreen: BottomNavItem(
        R.string.meeting,
        R.drawable.meeting_icon,
        "meeting_screen"
    )
}