package ru.faimizufarov.worker.features.vacancy.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VacancyViewModel
    @Inject constructor(
        private val getVacanciesUseCase: ru.faimizufarov.worker.domain.usecase.GetVacanciesUseCase
    ): ViewModel() {
    private val _vacanciesLiveData = MutableLiveData<List<ru.faimizufarov.worker.domain.models.Vacancy>>()
    val vacanciesLiveData: LiveData<List<ru.faimizufarov.worker.domain.models.Vacancy>> = _vacanciesLiveData

    init {
        viewModelScope.launch {
            _vacanciesLiveData.value = getVacanciesUseCase.execute()
        }
    }
}