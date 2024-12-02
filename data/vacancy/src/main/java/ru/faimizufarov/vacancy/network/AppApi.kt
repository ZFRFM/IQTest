package ru.faimizufarov.vacancy.network

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

private val objectMapper = ObjectMapper().registerModules(
    KotlinModule.Builder().build()
)

private val retrofit =
    Retrofit.Builder()
        .baseUrl("https://api.hh.ru/")
        .addConverterFactory(JacksonConverterFactory.create(objectMapper))
        .build()

object AppApi {
    val retrofitService: AppApiInterface by lazy {
        retrofit.create(AppApiInterface::class.java)
    }
}