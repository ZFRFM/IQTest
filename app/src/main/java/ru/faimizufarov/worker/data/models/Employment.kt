package ru.faimizufarov.worker.data.models
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Employment(
    val id: String,
    val name: String
)
