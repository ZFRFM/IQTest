package ru.faimizufarov.worker.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.faimizufarov.worker.data.models.VacancyResponse
import ru.faimizufarov.worker.data.network.AppApi

class VacancyRepository {
    private val api = AppApi.retrofitService

    suspend fun getVacanciesList(): List<VacancyResponse> =
        withContext(Dispatchers.IO) {
            getVacanciesFromApi()
        }

    private suspend fun getVacanciesFromApi() = api.getResult().vacancies
}