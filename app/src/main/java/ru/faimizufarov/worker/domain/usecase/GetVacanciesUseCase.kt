package ru.faimizufarov.worker.domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.faimizufarov.worker.domain.repository.VacancyRepository
import javax.inject.Inject

class GetVacanciesUseCase
    @Inject constructor(
        private val vacancyRepository: VacancyRepository
    ) {
    suspend fun execute() =
        withContext(Dispatchers.IO) {
            vacancyRepository.getVacanciesList()
        }
}