package ru.faimizufarov.domain.repository

import ru.faimizufarov.domain.models.Vacancy

interface VacancyRepository {
    suspend fun getVacanciesList(): List<Vacancy>
}