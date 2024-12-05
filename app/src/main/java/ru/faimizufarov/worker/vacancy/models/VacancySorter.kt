package ru.faimizufarov.worker.vacancy.models

sealed class VacancySorter(
    val id: String,
    val sorterName: String
) {
    data object RelevanceSort: VacancySorter(
        id = "relevance",
        sorterName = "По соответствию"
    )

    data object DateSort: VacancySorter(
        id = "publication_time",
        sorterName = "По дате публикации"
    )
}