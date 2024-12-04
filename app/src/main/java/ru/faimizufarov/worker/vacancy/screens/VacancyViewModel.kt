package ru.faimizufarov.worker.vacancy.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.faimizufarov.worker.data.models.VacancyResponse
import ru.faimizufarov.worker.data.repository.VacancyRepository
import ru.faimizufarov.worker.vacancy.models.VacancyCompose
import javax.inject.Inject

@HiltViewModel
class VacancyViewModel
    @Inject constructor(
        private val vacancyRepository: VacancyRepository
    ): ViewModel() {
    private val _vacanciesLiveData = MutableLiveData<List<VacancyCompose>>()
    val vacanciesLiveData: LiveData<List<VacancyCompose>> = _vacanciesLiveData

    fun retrieveData() {
        viewModelScope.launch {
            _vacanciesLiveData.value = vacancyRepository.getVacanciesList().map { vacancyResponse ->
                vacancyResponse.toVacancyCompose()
            }
        }
    }

    private fun VacancyResponse.toVacancyCompose() = VacancyCompose(
        vacancyName = vacancyName,
        createdAt = createdAt,
        employerName = employer?.name,
        salary = if (salary != null) "${salary.from}-${salary.to} ${salary.currency}"
        else null,
        area = area?.name
    )
}