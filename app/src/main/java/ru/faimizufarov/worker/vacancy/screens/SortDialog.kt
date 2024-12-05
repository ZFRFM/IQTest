package ru.faimizufarov.worker.vacancy.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import ru.faimizufarov.worker.vacancy.models.VacancySorter

@Composable
fun SortDialog(
    currentVacancySorter: VacancySorter,
    onVacancySorterChange: (VacancySorter) -> Unit,
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = { onDismissRequest() }
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(0.9f),
            shape = RoundedCornerShape(10)
        ) {
            Column {
                Text(
                    text = "Сортировка",
                    modifier = Modifier.fillMaxWidth().padding(
                        top = 12.dp,
                        bottom = 4.dp
                    ),
                    fontWeight = Bold,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium
                )
                VacancySorterItem(
                    sorterName = VacancySorter.RelevanceSort.sorterName,
                    selected = currentVacancySorter is VacancySorter.RelevanceSort,
                    onClick = {
                        onVacancySorterChange(VacancySorter.RelevanceSort)
                        onDismissRequest()
                    }
                )
                VacancySorterItem(
                    sorterName = VacancySorter.DateSort.sorterName,
                    selected = currentVacancySorter is VacancySorter.DateSort,
                    onClick = {
                        onVacancySorterChange(VacancySorter.DateSort)
                        onDismissRequest()
                    }
                )
            }
        }
    }
}

@Composable
fun VacancySorterItem(sorterName: String, selected: Boolean, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(
                top = 4.dp,
                bottom = 4.dp,
                start = 12.dp
            )
    ) {
        RadioButton(selected = selected, onClick = onClick)
        Text(text = sorterName, modifier = Modifier.padding(start = 8.dp))
    }
}