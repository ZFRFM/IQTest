package ru.faimizufarov.vacancy.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.faimizufarov.domain.models.Vacancy
import ru.faimizufarov.domain.repository.VacancyRepository
import ru.faimizufarov.vacancy.mapper.toVacancy
import ru.faimizufarov.vacancy.network.AppApi

class VacancyRepositoryImpl: VacancyRepository {
    private val api = AppApi.retrofitService

    override suspend fun getVacanciesList(): List<Vacancy> =
        withContext(Dispatchers.IO) {
            getVacanciesFromApi()
        }

    private suspend fun getVacanciesFromApi() =
        api.getResult()
            .vacancies
            .map { vacancyResponse ->
                vacancyResponse.toVacancy()
            }
}