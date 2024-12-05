package ru.faimizufarov.worker.data.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class FiltersResponse(
    val experience: Experience?,
    val employment: Employment?,
    val schedule: Schedule?,
    @JsonProperty("work_format")
    val workFormat: WorkFormat?
)
