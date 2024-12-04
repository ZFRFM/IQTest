package ru.faimizufarov.worker.features.vacancy.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.faimizufarov.worker.features.vacancy.models.VacancyCompose

@Composable
fun VacancyScreenBase(
    vacanciesList: List<VacancyCompose>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier =
        modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        items(vacanciesList) { vacancy ->
            VacancyItem(
                modifier = Modifier.fillMaxWidth(),
                vacancy = vacancy
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}