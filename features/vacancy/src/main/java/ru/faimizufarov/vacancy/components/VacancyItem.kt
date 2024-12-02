package ru.faimizufarov.vacancy.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.faimizufarov.core.theme.WorkerTheme

@Composable
internal fun VacancyItem(
    modifier: Modifier = Modifier
) {
    Card(modifier = Modifier) {
        Column(
            modifier = Modifier.padding(
                top = 20.dp,
                start = 16.dp
            )
        ) {
            Text(
                text = "Фрезеровщик",
                color = Color(0xFF282828)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text(
                    text = "Создано:",
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .width(150.dp),
                    color = Color.Gray
                )
                Text(
                    text = "10.10.2024",
                    modifier = Modifier
                        .padding(vertical = 4.dp),
                    color = Color(0xFF1D1B20)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Компания:",
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .width(150.dp),
                    color = Color.Gray
                )
                Text(
                    text = "Не указано",
                    modifier = Modifier
                        .padding(vertical = 4.dp),
                    color = Color(0xFF1D1B20)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Зарплата:",
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .width(150.dp),
                    color = Color.Gray
                )
                Text(
                    text = "Убрать, если не указано",
                    modifier = Modifier
                        .padding(vertical = 4.dp),
                    color = Color(0xFF1D1B20)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Text(
                    text = "Местоположение:",
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .width(150.dp),
                    color = Color.Gray
                )
                Text(
                    text = "Не указано",
                    modifier = Modifier
                        .padding(vertical = 4.dp),
                    color = Color(0xFF1D1B20)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewVacancyItem() {
    WorkerTheme {
        VacancyItem()
    }
}