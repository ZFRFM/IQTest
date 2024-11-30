package ru.faimizufarov.hiring

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import ru.faimizufarov.core.theme.WorkerTheme

@Composable
fun HiringScreen() {
    Column(
        modifier = Modifier
            .background(Color(0xFFFFFFFF))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(ru.faimizufarov.core.R.string.empty_screen_text),
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
fun PreviewHiringScreen() {
    WorkerTheme {
        HiringScreen()
    }
}