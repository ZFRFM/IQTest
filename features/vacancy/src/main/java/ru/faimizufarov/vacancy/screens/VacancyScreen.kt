package ru.faimizufarov.vacancy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import ru.faimizufarov.core.theme.WorkerTheme
import ru.faimizufarov.vacancy.components.VacancySearchBar

@Composable
fun VacancyScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F4F4)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        VacancySearchBar()

        Text(
            text = "In progress",
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
fun PreviewHiringScreen() {
    WorkerTheme {
        VacancyScreen()
    }
}