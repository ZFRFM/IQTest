package ru.faimizufarov.worker.data.network

import retrofit2.http.GET
import ru.faimizufarov.worker.data.models.ResultResponse

interface AppApiInterface {
    @GET("vacancies")
    suspend fun getResult(): ResultResponse
}