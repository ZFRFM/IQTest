package ru.faimizufarov.worker.vacancy.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ru.faimizufarov.worker.vacancy.components.FiltersScreenBase

@Composable
fun FiltersScreen(
    vacancyViewModel: VacancyViewModel = hiltViewModel()
) {
    val filters by vacancyViewModel.filters.collectAsState()
    val dictionaries by vacancyViewModel.dictionaries.collectAsState()

    if (dictionaries != null) {
        FiltersScreenBase(
            filters = filters,
            availableFilters = dictionaries!!
        ) { filterType, filterId, filterName ->
            vacancyViewModel.updateFilters(filterType, filterId, filterName)
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Загрузка фильтров...")
        }
    }
}