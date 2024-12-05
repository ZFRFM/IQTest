package ru.faimizufarov.worker.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.faimizufarov.worker.data.models.VacancyResponse
import ru.faimizufarov.worker.data.network.AppApi
import ru.faimizufarov.worker.data.paging.VacancyPagingSource

class VacancyRepository {
    private val api = AppApi.retrofitService

    fun getVacanciesFlow(): Flow<PagingData<VacancyResponse>> =
        Pager(
            config = PagingConfig(
                pageSize = 8,
                prefetchDistance = 2,
                initialLoadSize = 8,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { VacancyPagingSource(api) }
        ).flow
}
