package ru.faimizufarov.worker.vacancy.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilterItem(
    filterName: String,
    filters: List<String>,
    selectedFilter: String?,
    onFilterSelected: (String?) -> Unit
) {
    var expandedDropdownMenu by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Text(
            text = filterName,
            modifier = Modifier.padding(bottom = 4.dp),
            fontSize = 20.sp,
            color = Color(0xFF1A1A1F)
        )

        TextField(
            value = selectedFilter ?: filterName,
            onValueChange = {},
            modifier = Modifier
                .clickable { expandedDropdownMenu = !expandedDropdownMenu }
                .fillMaxWidth(),
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { expandedDropdownMenu = !expandedDropdownMenu }) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                }
            },
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            )
        )

        DropdownMenu(
            expanded = expandedDropdownMenu,
            onDismissRequest = { expandedDropdownMenu = false }
        ) {
            filters.forEach { filter ->
                DropdownMenuItem(
                    text = {
                        Text(filter)
                    },
                    onClick = {
                        onFilterSelected(filter)
                        expandedDropdownMenu = false
                    })
            }
        }
    }
}