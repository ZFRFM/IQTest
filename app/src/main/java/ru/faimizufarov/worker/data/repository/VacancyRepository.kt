package ru.faimizufarov.worker.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withTimeout
import retrofit2.HttpException
import ru.faimizufarov.worker.data.network.AppApi
import ru.faimizufarov.worker.data.paging.VacancyPagingSource
import ru.faimizufarov.worker.vacancy.models.VacancySorter

class VacancyRepository {
    private val api = AppApi.retrofitService

    suspend fun getFilters() =
        try {
            withTimeout(7000) {
                api.getFilters()
            }
        } catch (httpException: HttpException) {
            error("httpException in VacancyRepository")
        } catch (timeoutCancellationException: TimeoutCancellationException) {
            error("timeoutCancellationException in VacancyRepository")
        }

    fun getVacanciesFlow(
        searchText: String?,
        experience: String?,
        employment: String?,
        schedule: String?,
        workFormat: String?,
        vacancySorter: VacancySorter
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
                    workFormat = workFormat,
                    vacancySorter = vacancySorter
                )
            }
        ).flow
}
