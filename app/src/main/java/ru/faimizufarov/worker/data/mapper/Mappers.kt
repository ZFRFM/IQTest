package ru.faimizufarov.worker.data.mapper

import ru.faimizufarov.worker.domain.models.Vacancy
import ru.faimizufarov.worker.data.models.Area
import ru.faimizufarov.worker.data.models.Employer
import ru.faimizufarov.worker.data.models.Employment
import ru.faimizufarov.worker.data.models.Experience
import ru.faimizufarov.worker.data.models.Salary
import ru.faimizufarov.worker.data.models.Schedule
import ru.faimizufarov.worker.data.models.VacancyResponse

internal fun VacancyResponse.toVacancy() =
    Vacancy(
        id = id,
        vacancyName = vacancyName,
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
    ru.faimizufarov.worker.domain.models.Employer(
        id = id,
        name = name
    )

internal fun Salary.toDomainSalary() =
    ru.faimizufarov.worker.domain.models.Salary(
        from = from,
        to = to,
        currency = currency
    )

internal fun Area.toDomainArea() =
    ru.faimizufarov.worker.domain.models.Area(
        id = id,
        name = name
    )

internal fun Experience.toDomainExperience() =
    ru.faimizufarov.worker.domain.models.Experience(
        id = id,
        name = name
    )

internal fun Employment.toDomainEmployment() =
    ru.faimizufarov.worker.domain.models.Employment(
        id = id,
        name = name
    )

internal fun Schedule.toDomainSchedule() =
    ru.faimizufarov.worker.domain.models.Schedule(
        id = id,
        name = name
    )