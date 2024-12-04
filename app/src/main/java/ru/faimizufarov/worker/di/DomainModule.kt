package ru.faimizufarov.worker.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.faimizufarov.worker.domain.repository.VacancyRepository
import ru.faimizufarov.worker.domain.usecase.GetVacanciesUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    @Singleton
    fun provideGetVacanciesUseCase(vacancyRepository: VacancyRepository) =
        GetVacanciesUseCase(vacancyRepository = vacancyRepository)
}