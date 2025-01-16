package com.el3sas.domain.usecaes

import com.el3sas.domain.repo.WeatherRepo
import javax.inject.Inject

class GetLastSelectedCityName @Inject constructor(private val repo: WeatherRepo) {
    operator fun invoke() = repo.getLastSelectedCityName()
}