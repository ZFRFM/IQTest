package ru.faimizufarov.worker.vacancy.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.faimizufarov.worker.data.models.FiltersResponse
import ru.faimizufarov.worker.vacancy.models.FilterType
import ru.faimizufarov.worker.vacancy.models.FiltersState

@Composable
fun FiltersScreenBase(
    filters: FiltersState,
    availableFilters: FiltersResponse,
    onFilterSelected: (FilterType, String?) -> Unit,
) {
    Column {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            item {
                FilterItem(
                    filterName = FilterType.EXPERIENCE.filterName,
                    filters = availableFilters.experience.map { it.name },
                    selectedFilter = filters.experience,
                    onFilterSelected = { onFilterSelected(FilterType.EXPERIENCE, it) }
                )
            }
            item {
                FilterItem(
                    filterName = FilterType.EMPLOYMENT.filterName,
                    filters = availableFilters.employment.map { it.name },
                    selectedFilter = filters.employment,
                    onFilterSelected = { onFilterSelected(FilterType.EMPLOYMENT, it) }
                )
            }
            item {
                FilterItem(
                    filterName = FilterType.SCHEDULE.filterName,
                    filters = availableFilters.schedule.map { it.name },
                    selectedFilter = filters.schedule,
                    onFilterSelected = { onFilterSelected(FilterType.SCHEDULE, it) }
                )
            }
            item {
                FilterItem(
                    filterName = FilterType.WORK_FORMAT.filterName,
                    filters = availableFilters.workFormat.map { it.name },
                    selectedFilter = filters.workFormat,
                    onFilterSelected = { onFilterSelected(FilterType.WORK_FORMAT, it) }
                )
            }
        }
    }
}