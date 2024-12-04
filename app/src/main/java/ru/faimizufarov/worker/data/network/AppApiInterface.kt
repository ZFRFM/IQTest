package ru.faimizufarov.worker.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import ru.faimizufarov.worker.data.models.ResultResponse

interface AppApiInterface {
    @GET("vacancies")
    suspend fun getResult(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): ResultResponse
}