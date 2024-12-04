package ru.faimizufarov.worker.data.models

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ResultResponse(
    @JsonProperty("items") val vacancies: List<VacancyResponse>,
    val pages: Int,
    val page: Int
)
