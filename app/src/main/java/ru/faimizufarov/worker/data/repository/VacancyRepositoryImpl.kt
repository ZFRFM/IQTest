package ru.faimizufarov.worker.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.faimizufarov.worker.domain.models.Vacancy
import ru.faimizufarov.worker.domain.repository.VacancyRepository
import ru.faimizufarov.worker.data.mapper.toVacancy
import ru.faimizufarov.worker.data.network.AppApi

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