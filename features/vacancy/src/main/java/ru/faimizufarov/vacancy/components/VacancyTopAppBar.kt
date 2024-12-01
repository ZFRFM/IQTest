package ru.faimizufarov.vacancy.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.faimizufarov.core.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VacancyTopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.vacancies),
                modifier = Modifier,
                fontSize = 24.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {  },
                modifier = Modifier
                    .size(48.dp)
                    .padding(
                        top = 8.dp,
                        bottom = 8.dp,
                        start = 4.dp
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Меню",
                    modifier = Modifier
                )
            }
        },
        actions = {
            Box(
                modifier = Modifier
                    .padding(
                        top = 12.dp,
                        bottom = 12.dp,
                        end = 16.dp
                    )
                    .size(40.dp)
                    .background(color = Color(0xFFDDDDDD), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "АС",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
            }
        }
    )
}