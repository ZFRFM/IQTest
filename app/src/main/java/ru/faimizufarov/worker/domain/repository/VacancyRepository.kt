package ru.faimizufarov.worker.domain.repository

import ru.faimizufarov.worker.domain.models.Vacancy

interface VacancyRepository {
    suspend fun getVacanciesList(): List<Vacancy>
}