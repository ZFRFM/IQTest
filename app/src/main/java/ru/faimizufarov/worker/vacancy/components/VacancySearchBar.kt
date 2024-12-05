package ru.faimizufarov.worker.vacancy.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.faimizufarov.worker.R
import ru.faimizufarov.worker.theme.WorkerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VacancySearchBar(
    modifier: Modifier = Modifier,
    searchText: String,
    onSearch: (String) -> Unit = {},
    onFilterClick: () -> Unit = {},
    onSortClick: () -> Unit = {}
) {
    TextField(
        value = searchText,
        onValueChange = { onSearch(it) },
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
            .fillMaxWidth(),
        placeholder = { Text(text = "Поиск", color = Color.Gray) },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.search_icon),
                contentDescription = "Search",
                tint = Color.Gray,
                modifier = Modifier.padding(start = 16.dp)
            )
        },
        trailingIcon = {
            Row (modifier = Modifier) {
                IconButton(onClick = onFilterClick) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.filter_icon),
                        contentDescription = "Filter",
                        tint = Color.Gray
                    )
                }

                IconButton(onClick = onSortClick) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.sort_icon),
                        contentDescription = "Sort",
                        tint = Color.Gray
                    )
                }
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(28.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Gray
        )
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewVacancyScreenBar() {
    WorkerTheme {
        VacancySearchBar(
            modifier = Modifier,
            searchText = "check"
        )
    }
}