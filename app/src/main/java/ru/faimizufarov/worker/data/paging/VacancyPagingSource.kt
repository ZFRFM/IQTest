package ru.faimizufarov.worker.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.faimizufarov.worker.data.models.VacancyResponse
import ru.faimizufarov.worker.data.network.AppApiInterface
import ru.faimizufarov.worker.vacancy.models.VacancySorter

class VacancyPagingSource(
    private val appApiInterface: AppApiInterface,
    private val searchText: String?,
    private val experience: String?,
    private val employment: String?,
    private val schedule: String?,
    private val workFormat: String?,
    private val vacancySorter: VacancySorter
): PagingSource<Int, VacancyResponse>() {
    override fun getRefreshKey(state: PagingState<Int, VacancyResponse>) =
        state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, VacancyResponse> {
        return try {
            val currentPage = params.key ?: 0
            val response = appApiInterface.getResult(
                text = searchText,
                page = currentPage,
                perPage = params.loadSize,
                experienceId = experience,
                employmentId = employment,
                scheduleId = schedule,
                workFormatId = workFormat,
                orderBy = vacancySorter.id
            )
            val vacancies = response.vacancies

            LoadResult.Page(
                data = vacancies,
                prevKey = if (currentPage == 0) null else currentPage - 1,
                nextKey = if (currentPage == response.pages - 1) null else currentPage + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}
