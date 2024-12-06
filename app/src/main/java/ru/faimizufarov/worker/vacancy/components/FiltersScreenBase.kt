package ru.faimizufarov.worker.vacancy.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.faimizufarov.worker.data.models.FiltersResponse
import ru.faimizufarov.worker.vacancy.models.FilterType
import ru.faimizufarov.worker.vacancy.models.FiltersState

@Composable
fun FiltersScreenBase(
    filters: FiltersState?,
    availableFilters: FiltersResponse,
    onFilterSelected: (FilterType, String, String) -> Unit,
) {
    Column {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            item {
                FilterItem(
                    filterName = FilterType.EXPERIENCE.filterName,
                    experienceFilters = availableFilters.experience,
                    selectedFilter = filters?.experience?.name,
                    onFilterSelected = { filterId, filterName ->
                        onFilterSelected(FilterType.EXPERIENCE, filterId, filterName)
                    },
                    employmentFilters = null,
                    scheduleFilters = null,
                    workFormatFilters = null
                )
            }
            item {
                FilterItem(
                    filterName = FilterType.EMPLOYMENT.filterName,
                    employmentFilters = availableFilters.employment,
                    selectedFilter = filters?.employment?.name,
                    onFilterSelected = { filterId, filterName ->
                        onFilterSelected(FilterType.EMPLOYMENT, filterId, filterName)
                    },
                    experienceFilters = null,
                    scheduleFilters = null,
                    workFormatFilters = null
                )
            }
            item {
                FilterItem(
                    filterName = FilterType.SCHEDULE.filterName,
                    scheduleFilters = availableFilters.schedule,
                    selectedFilter = filters?.schedule?.name,
                    onFilterSelected = { filterId, filterName ->
                        onFilterSelected(FilterType.SCHEDULE, filterId, filterName)
                    },
                    experienceFilters = null,
                    employmentFilters = null,
                    workFormatFilters = null
                )
            }
            item {
                FilterItem(
                    filterName = FilterType.WORK_FORMAT.filterName,
                    workFormatFilters = availableFilters.workFormat,
                    selectedFilter = filters?.workFormat?.name,
                    onFilterSelected = { filterId, filterName ->
                        onFilterSelected(FilterType.WORK_FORMAT, filterId, filterName)
                    },
                    experienceFilters = null,
                    employmentFilters = null,
                    scheduleFilters = null
                )
            }
            item {
                Button(
                    onClick = {  },
                    modifier = Modifier.padding(top = 20.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF282828)
                    )
                ) {
                    Text(
                        text = "Применить",
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        fontSize = 20.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )

                }
            }
        }
    }
}