package ru.faimizufarov.worker.vacancy.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
    onFilterSelected: (String) -> Unit
) {
    val localSelectedFilter = rememberSaveable{
        selectedFilter ?: "Select $filterName"
    }
    var expandedDropdownMenu by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
    ) {
        Text(
            text = filterName,
            modifier = Modifier.padding(bottom = 8.dp),
            fontSize = 20.sp,
            color = Color(0xFF1A1A1F)
        )

        TextField(
            value = localSelectedFilter,
            onValueChange = {},
            label = { Text(
                text = filterName,
                color = Color(0xFF8E8E8E)
            ) },
            trailingIcon = {
                IconButton(onClick = { expandedDropdownMenu = !expandedDropdownMenu }) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                }
            }
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