package ru.faimizufarov.vacancy.network

import retrofit2.http.GET
import ru.faimizufarov.vacancy.models.ResultResponse

interface AppApiInterface {
    @GET("vacancies")
    suspend fun getResult(): ResultResponse
}