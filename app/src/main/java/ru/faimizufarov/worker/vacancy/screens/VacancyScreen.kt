package ru.faimizufarov.worker.vacancy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import ru.faimizufarov.worker.theme.WorkerTheme
import ru.faimizufarov.worker.vacancy.components.VacancyScreenBase
import ru.faimizufarov.worker.vacancy.components.VacancySearchBar

@Composable
fun VacancyScreen(
    vacancyViewModel: VacancyViewModel = hiltViewModel()
) {
    val vacancies = vacancyViewModel.vacanciesFlow.collectAsLazyPagingItems()
    val searchText by vacancyViewModel.searchText.collectAsState()
    val vacancySorter by vacancyViewModel.vacancySorter.collectAsState()
    var isSortDialogVisible by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F4F4)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        VacancySearchBar(
            modifier = Modifier,
            searchText = searchText.orEmpty(),
            onSearch = { vacancyViewModel.updateSearchText(it) },
            onSortClick = { isSortDialogVisible = true }
        )

        VacancyScreenBase(
            vacanciesList = vacancies
        )

        if (isSortDialogVisible) {
            SortDialog(
                currentVacancySorter = vacancySorter,
                onVacancySorterChange = { vacancySorter ->
                    vacancyViewModel.setVacancySorter(vacancySorter)
                    isSortDialogVisible = false
                },
                onDismissRequest = { isSortDialogVisible = false }
            )
        }
    }
}

@Preview
@Composable
fun PreviewHiringScreen() {
    WorkerTheme {
        VacancyScreen()
    }
}