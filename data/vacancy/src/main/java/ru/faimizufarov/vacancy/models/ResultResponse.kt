package ru.faimizufarov.vacancy.models

import com.fasterxml.jackson.annotation.JsonProperty

data class ResultResponse(
    @JsonProperty("items") val vacancies: List<VacancyResponse>
)
