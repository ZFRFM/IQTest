package ru.faimizufarov.worker.vacancy.models

import ru.faimizufarov.worker.data.models.Employment
import ru.faimizufarov.worker.data.models.Experience
import ru.faimizufarov.worker.data.models.Schedule
import ru.faimizufarov.worker.data.models.WorkFormat

data class FiltersState(
    val experience: Experience? = null,
    val employment: Employment? = null,
    val schedule: Schedule? = null,
    val workFormat: WorkFormat? = null
)

enum class FilterType(
    val filterName: String
) {
    EXPERIENCE(filterName = "Опыт работы"),
    EMPLOYMENT(filterName = "Тип занятости"),
    SCHEDULE(filterName = "График работы"),
    WORK_FORMAT(filterName = "Формат работы")
}