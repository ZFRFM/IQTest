package ru.faimizufarov.worker.vacancy.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.faimizufarov.worker.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterTopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.filters),
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
                    imageVector = Icons.Default.Close,
                    contentDescription = "Меню",
                    modifier = Modifier
                )
            }
        },
        actions = {
            Text(
                text = stringResource(R.string.clear),
                modifier = Modifier.padding(end = 16.dp),
                color = Color(0xFF8E8E8E)
            )
        },
        colors = TopAppBarColors(
            containerColor = Color(0xFFF4F4F4),
            scrolledContainerColor = Color.Transparent,
            navigationIconContentColor = Color(0xFF444748),
            titleContentColor = Color.Transparent,
            actionIconContentColor = Color.Transparent
        )
    )
}

@Preview
@Composable
fun PreviewFilterTopAppBar() {
    ru.faimizufarov.worker.theme.WorkerTheme {
        FilterTopAppBar()
    }
}