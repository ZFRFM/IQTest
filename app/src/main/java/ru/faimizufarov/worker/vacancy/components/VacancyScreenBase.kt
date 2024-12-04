package ru.faimizufarov.worker.vacancy.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import ru.faimizufarov.worker.vacancy.models.VacancyCompose

@Composable
fun VacancyScreenBase(
    vacanciesList: LazyPagingItems<VacancyCompose>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier =
        modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        items(vacanciesList.itemCount) {index: Int ->
            vacanciesList[index]?.let {
                VacancyItem(
                    vacancy = it
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}