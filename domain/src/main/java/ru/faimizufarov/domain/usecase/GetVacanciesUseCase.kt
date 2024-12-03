package ru.faimizufarov.domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.faimizufarov.domain.repository.VacancyRepository

class GetVacanciesUseCase(private val vacancyRepository: VacancyRepository) {
    suspend fun execute() =
        withContext(Dispatchers.IO) {
            vacancyRepository.getVacanciesList()
        }
}