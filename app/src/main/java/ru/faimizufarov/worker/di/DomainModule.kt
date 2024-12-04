package ru.faimizufarov.worker.di

import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.faimizufarov.worker.domain.repository.VacancyRepository
import ru.faimizufarov.worker.domain.usecase.GetVacanciesUseCase
import javax.inject.Singleton

@EntryPoint
@InstallIn(SingletonComponent::class)
interface DomainModule {
    @Provides
    @Singleton
    fun provideGetVacanciesUseCase(vacancyRepository: VacancyRepository) =
        GetVacanciesUseCase(vacancyRepository = vacancyRepository)
}