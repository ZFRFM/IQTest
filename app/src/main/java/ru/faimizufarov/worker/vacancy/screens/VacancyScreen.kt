package ru.faimizufarov.worker.vacancy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import ru.faimizufarov.worker.vacancy.components.VacancyScreenBase
import ru.faimizufarov.worker.vacancy.components.VacancySearchBar

@Composable
fun VacancyScreen(vacancyViewModel: VacancyViewModel = hiltViewModel()) {
    val vacancies = vacancyViewModel.vacanciesFlow.collectAsLazyPagingItems()
    val searchText by vacancyViewModel.searchText.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F4F4)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        VacancySearchBar(
            modifier = Modifier,
            searchText = searchText.orEmpty(),
            onSearch = { vacancyViewModel.updateSearchText(it) }
        )

        VacancyScreenBase(
            vacanciesList = vacancies
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