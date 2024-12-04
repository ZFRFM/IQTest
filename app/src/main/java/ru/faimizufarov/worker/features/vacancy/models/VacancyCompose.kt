package ru.faimizufarov.worker.features.vacancy.models

import androidx.compose.runtime.Immutable

@Immutable
data class VacancyCompose(
    val vacancyName: String,
    val createdAt: String,
    val employerName: String,
    val salary: String,
    val area: String
)
