package ru.faimizufarov.vacancy.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.faimizufarov.domain.repository.VacancyRepository
import ru.faimizufarov.vacancy.repository.VacancyRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideVacancyRepository(): VacancyRepository = VacancyRepositoryImpl()
}