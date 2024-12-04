package ru.faimizufarov.worker.data.models
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Salary(
    val from: Int,
    val to: Int,
    val currency: String
)
