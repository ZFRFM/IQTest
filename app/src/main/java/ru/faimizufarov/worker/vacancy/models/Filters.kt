package ru.faimizufarov.worker.vacancy.models

data class Filters(
    val experience: String? = null,
    val employment: String? = null,
    val schedule: String? = null,
    val workFormat: String? = null
)