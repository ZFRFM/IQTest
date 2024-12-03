package ru.faimizufarov.vacancy.mapper

import ru.faimizufarov.domain.models.Vacancy
import ru.faimizufarov.vacancy.models.Area
import ru.faimizufarov.vacancy.models.Employer
import ru.faimizufarov.vacancy.models.Employment
import ru.faimizufarov.vacancy.models.Experience
import ru.faimizufarov.vacancy.models.Salary
import ru.faimizufarov.vacancy.models.Schedule
import ru.faimizufarov.vacancy.models.VacancyResponse

internal fun VacancyResponse.toVacancy() =
    Vacancy(
        id = id,
        vacancyResponse = vacancyResponse,
        createdAt = createdAt,
        employer = employer?.toDomainEmployer(),
        salary = salary?.toDomainSalary(),
        area = area?.toDomainArea(),
        experience = experience?.toDomainExperience(),
        employment = employment?.toDomainEmployment(),
        schedule = schedule?.toDomainSchedule(),
        publishedAt = publishedAt
    )

internal fun Employer.toDomainEmployer() =
    ru.faimizufarov.domain.models.Employer(
        id = id,
        name = name
    )

internal fun Salary.toDomainSalary() =
    ru.faimizufarov.domain.models.Salary(
        from = from,
        to = to,
        currency = currency
    )

internal fun Area.toDomainArea() =
    ru.faimizufarov.domain.models.Area(
        id = id,
        name = name
    )

internal fun Experience.toDomainExperience() =
    ru.faimizufarov.domain.models.Experience(
        id = id,
        name = name
    )

internal fun Employment.toDomainEmployment() =
    ru.faimizufarov.domain.models.Employment(
        id = id,
        name = name
    )

internal fun Schedule.toDomainSchedule() =
    ru.faimizufarov.domain.models.Schedule(
        id = id,
        name = name
    )