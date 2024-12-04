package ru.faimizufarov.worker.data.models

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class VacancyResponse(
    val id: String,
    @JsonProperty("name")
    val vacancyName: String,
    @JsonProperty("created_at")
    val createdAt: String,
    val employer: Employer?,
    val salary: Salary?,
    val area: Area?,
    val experience: Experience?,
    val employment: Employment?,
    val schedule: Schedule?,
    @JsonProperty("published_at")
    val publishedAt: String
)
