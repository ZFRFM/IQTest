package ru.faimizufarov.worker.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import ru.faimizufarov.worker.data.network.AppApi
import ru.faimizufarov.worker.data.paging.VacancyPagingSource

class VacancyRepository {
    private val api = AppApi.retrofitService

    suspend fun getFilters() = api.getFilters()

    fun getVacanciesFlow(
        searchText: String?,
        experience: String?,
        employment: String?,
        schedule: String?,
        workFormat: String?
    ) =
        Pager(
            config = PagingConfig(
                pageSize = 8,
                prefetchDistance = 2,
                initialLoadSize = 8,
                enablePlaceholders = true
            ),
            pagingSourceFactory = {
                VacancyPagingSource(
                    appApiInterface = api,
                    searchText = searchText,
                    experience = experience,
                    employment = employment,
                    schedule = schedule,
                    workFormat = workFormat
                )
            }
        ).flow
}
