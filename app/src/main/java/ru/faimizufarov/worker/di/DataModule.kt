package ru.faimizufarov.worker.di

import dagger.Binds
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.faimizufarov.worker.domain.repository.VacancyRepository
import ru.faimizufarov.worker.data.repository.VacancyRepositoryImpl
import javax.inject.Singleton

@EntryPoint
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideVacancyRepository(
        vacancyRepositoryImpl: VacancyRepositoryImpl
    ): VacancyRepository
}