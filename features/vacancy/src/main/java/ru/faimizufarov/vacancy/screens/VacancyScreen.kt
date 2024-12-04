package ru.faimizufarov.vacancy.screens

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
import ru.faimizufarov.core.theme.WorkerTheme
import ru.faimizufarov.domain.models.Vacancy
import ru.faimizufarov.vacancy.components.VacancyScreenBase
import ru.faimizufarov.vacancy.components.VacancySearchBar
import ru.faimizufarov.vacancy.models.VacancyCompose

@Composable
fun VacancyScreen() {
    val vacanciesViewModel = hiltViewModel<VacancyViewModel>()
    val vacanciesList = vacanciesViewModel.vacanciesLiveData.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F4F4)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        VacancySearchBar()

        VacancyScreenBase(
            vacanciesList = vacanciesList.value.map { vacancy: Vacancy ->
                vacancy.toVacancyCompose()
            }
        )
    }
}

private fun Vacancy.toVacancyCompose() =
    VacancyCompose(
        vacancyName = vacancyName,
        createdAt = createdAt,
        employerName = employer?.name ?: "",
        salary = "${salary?.from}-${salary?.to} ${salary?.currency}",
        area = area?.name ?: ""
    )

@Preview
@Composable
fun PreviewHiringScreen() {
    WorkerTheme {
        VacancyScreen()
    }
}