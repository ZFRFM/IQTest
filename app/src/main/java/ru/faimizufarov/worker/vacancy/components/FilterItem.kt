package ru.faimizufarov.worker.vacancy.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.faimizufarov.worker.data.models.Employment
import ru.faimizufarov.worker.data.models.Experience
import ru.faimizufarov.worker.data.models.Schedule
import ru.faimizufarov.worker.data.models.WorkFormat

@Composable
fun FilterItem(
    filterName: String,
    experienceFilters: List<Experience>?,
    employmentFilters: List<Employment>?,
    scheduleFilters: List<Schedule>?,
    workFormatFilters: List<WorkFormat>?,
    selectedFilter: String?,
    onFilterSelected: (String, String) -> Unit
) {
    var expandedDropdownMenu by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Text(
            text = filterName,
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    bottom = 4.dp,
                ),
            fontSize = 20.sp,
            color = Color(0xFF1A1A1F)
        )

        TextField(
            value = selectedFilter ?: filterName,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { expandedDropdownMenu = !expandedDropdownMenu }) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                }
            },
            interactionSource = remember { MutableInteractionSource() }
                .also { interactionSource ->
                    LaunchedEffect(interactionSource) {
                        interactionSource.interactions.collect {
                            if (it is PressInteraction.Release) {
                                expandedDropdownMenu = !expandedDropdownMenu
                            }
                        }
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
            experienceFilters?.forEach { experience ->
                DropdownMenuItem(
                    text = {
                        Text(experience.name)
                    },
                    onClick = {
                        onFilterSelected(experience.id, experience.name)
                        expandedDropdownMenu = false
                    })
            }
            employmentFilters?.forEach { employment ->
                DropdownMenuItem(
                    text = {
                        Text(employment.name)
                    },
                    onClick = {
                        onFilterSelected(employment.id, employment.name)
                        expandedDropdownMenu = false
                    })
            }
            scheduleFilters?.forEach { schedule ->
                DropdownMenuItem(
                    text = {
                        Text(schedule.name)
                    },
                    onClick = {
                        onFilterSelected(schedule.id, schedule.name)
                        expandedDropdownMenu = false
                    })
            }
            workFormatFilters?.forEach { workFormat ->
                DropdownMenuItem(
                    text = {
                        Text(workFormat.name)
                    },
                    onClick = {
                        onFilterSelected(workFormat.id, workFormat.name)
                        expandedDropdownMenu = false
                    })
            }
        }
    }
}