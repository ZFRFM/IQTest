package ru.faimizufarov.worker.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import ru.faimizufarov.worker.data.models.FiltersResponse
import ru.faimizufarov.worker.data.models.ResultResponse

interface AppApiInterface {
    @GET("vacancies")
    suspend fun getResult(
        @Query("text") text: String? = null,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("experience") experience: String? = null,
        @Query("employment") employment: String? = null,
        @Query("schedule") schedule: String? = null,
        @Query("work_format") workFormat: String? = null,
        @Query("order_by") orderBy: String
    ): ResultResponse

    @GET("dictionaries")
    suspend fun getFilters(): FiltersResponse
}