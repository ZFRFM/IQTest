package ru.faimizufarov.worker.vacancy.models

data class Filters(
    val experience: String? = null,
    val employment: String? = null,
    val schedule: String? = null,
    val workFormat: String? = null
    // FIXME: Предположительно типы должны быть в списках, но на данный момент расходятся
    // FIXME: тип с сервера и тип UI -> фильтрация будет доделана после сортировки
)