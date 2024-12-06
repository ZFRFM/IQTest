package ru.faimizufarov.worker.data.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class FiltersResponse(
    val experience: List<Experience>,
    val employment: List<Employment>,
    val schedule: List<Schedule>,
    @JsonProperty("work_format")
    val workFormat: List<WorkFormat>
)
