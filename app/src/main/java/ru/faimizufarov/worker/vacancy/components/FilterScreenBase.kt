package ru.faimizufarov.worker.vacancy.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import ru.faimizufarov.worker.data.models.FiltersResponse
import ru.faimizufarov.worker.vacancy.models.Filters
import java.util.logging.Filter

@Composable
fun FilterScreenBase(
    filters: Filters,
    availableFilters: FiltersResponse?,
    onFilterSelected: (Filter) -> Unit
) {

}