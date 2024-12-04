package ru.faimizufarov.worker.vacancy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import ru.faimizufarov.worker.vacancy.components.VacancyScreenBase
import ru.faimizufarov.worker.vacancy.components.VacancySearchBar

@Composable
fun VacancyScreen(vacancyViewModel: VacancyViewModel = hiltViewModel()) {
    vacancyViewModel.retrieveData()
    val vacanciesList = vacancyViewModel.vacanciesLiveData.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F4F4)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        VacancySearchBar()

        VacancyScreenBase(
            vacanciesList = vacanciesList.value
        )
    }
}

@Preview
@Composable
fun PreviewHiringScreen() {
    ru.faimizufarov.worker.theme.WorkerTheme {
        VacancyScreen()
    }
}