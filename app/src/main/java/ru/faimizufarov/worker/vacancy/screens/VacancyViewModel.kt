package ru.faimizufarov.worker.vacancy.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import ru.faimizufarov.worker.data.models.Salary
import ru.faimizufarov.worker.data.models.VacancyResponse
import ru.faimizufarov.worker.data.repository.VacancyRepository
import ru.faimizufarov.worker.vacancy.models.Filters
import ru.faimizufarov.worker.vacancy.models.VacancyCompose
import ru.faimizufarov.worker.vacancy.models.VacancySorter
import javax.inject.Inject

@HiltViewModel
class VacancyViewModel
    @Inject constructor(
        private val vacancyRepository: VacancyRepository
    ): ViewModel() {

    private val _searchText = MutableStateFlow<String?>(null)
    val searchText = _searchText.asStateFlow()

    private val _filters = MutableStateFlow(Filters())
    val filters = _filters.asStateFlow()

    private val _vacancySorter = MutableStateFlow<VacancySorter>(VacancySorter.RelevanceSort)
    val vacancySorter = _vacancySorter.asStateFlow()

    @OptIn(ExperimentalCoroutinesApi::class)
    val vacanciesFlow: Flow<PagingData<VacancyCompose>> =
        combine(
            _searchText,
            _filters,
            _vacancySorter
        ) { localSearchText, localFilters, localVacancySorter ->
            Triple(localSearchText, localFilters, localVacancySorter)
        }.flatMapLatest { (localSearchText, localFilters, localVacancySorter) ->
            vacancyRepository.getVacanciesFlow(
                searchText = localSearchText,
                experience = localFilters.experience,
                employment = localFilters.employment,
                schedule = localFilters.schedule,
                workFormat = localFilters.workFormat,
                vacancySorter = localVacancySorter
            )
        }.map { pagingData ->
            pagingData.map { vacancyResponse ->
                vacancyResponse.toVacancyCompose()
            }
        }
            .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
            .cachedIn(viewModelScope)

    fun updateSearchText(text: String) {
        viewModelScope.launch {
            _searchText.value = text
        }
    }

    fun updateFilters(newFilters: Filters) {
        viewModelScope.launch {
            _filters.value = newFilters
        }
    }

    fun updateVacancySorter(vacancySorter: VacancySorter) {
        viewModelScope.launch {
            _vacancySorter.value = vacancySorter
        }
    }

    private fun VacancyResponse.toVacancyCompose() = VacancyCompose(
        vacancyName = vacancyName,
        createdAt = formatDateTime(createdAt),
        employerName = employer?.name,
        salary = handleSalaryInput(salary),
        area = area?.name
    )

    private fun formatDateTime(input: String): String {
        val correctedInput = input.replace(Regex("([+\\-])(\\d{2})(\\d{2})$")) {
            val sign = it.groupValues[1]
            val hours = it.groupValues[2]
            val minutes = it.groupValues[3]
            "$sign$hours:$minutes"
        }

        val instant = Instant.parse(correctedInput)

        val dateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())

        return dateTime.dayOfMonth.toString().padStart(2, '0') +
                ".${dateTime.monthNumber.toString().padStart(2, '0')}" +
                ".${dateTime.year}"
    }

    private fun handleSalaryInput(salary: Salary?): String? {
        return if (salary?.from == null && salary?.to != null) {
            "до ${salary.to} ${salary.currency}"
        } else if (salary?.from != null && salary.to == null) {
            "от ${salary.from} ${salary.currency}"
        } else if (salary != null) "${salary.from}-${salary.to} ${salary.currency}"
        else null
    }
}