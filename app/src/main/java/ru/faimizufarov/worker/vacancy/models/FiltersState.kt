package ru.faimizufarov.worker.vacancy.models

data class FiltersState(
    val experience: String? = null,
    val employment: String? = null,
    val schedule: String? = null,
    val workFormat: String? = null
)

enum class FilterType(
    val filterName: String
) {
    EXPERIENCE(filterName = "Опыт работы"),
    EMPLOYMENT(filterName = "Тип занятости"),
    SCHEDULE(filterName = "График работы"),
    WORK_FORMAT(filterName = "Формат работы")
}