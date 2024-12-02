package ru.faimizufarov.vacancy.models

import com.fasterxml.jackson.annotation.JsonProperty

data class VacancyResponse(
    val id: String,
    @JsonProperty("name")
    val vacancyResponse: String,
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
