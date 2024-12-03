package ru.faimizufarov.vacancy.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.faimizufarov.domain.models.Vacancy
import ru.faimizufarov.domain.usecase.GetVacanciesUseCase

class VacancyViewModel(
    private val getVacanciesUseCase: GetVacanciesUseCase
): ViewModel() {
    private val _vacanciesLiveData = MutableLiveData<List<Vacancy>>()
    val vacanciesLiveData: LiveData<List<Vacancy>> = _vacanciesLiveData

    init {
        viewModelScope.launch {
            _vacanciesLiveData.value = getVacanciesUseCase.execute()
        }
    }
}