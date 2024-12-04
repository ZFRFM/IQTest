package ru.faimizufarov.worker.features.vacancy.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun VacancyFloatingActionButton() {
    FloatingActionButton(
        onClick = { },
        containerColor = Color(0xFFFF9025),
        contentColor = Color.White
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add",
            tint = Color.Black
        )
    }
}