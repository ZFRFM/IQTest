package ru.faimizufarov.domain.models

data class Vacancy(
    val id: String,
    val vacancyResponse: String,
    val createdAt: String,
    val employer: Employer?,
    val salary: Salary?,
    val area: Area?,
    val experience: Experience?,
    val employment: Employment?,
    val schedule: Schedule?,
    val publishedAt: String
)
