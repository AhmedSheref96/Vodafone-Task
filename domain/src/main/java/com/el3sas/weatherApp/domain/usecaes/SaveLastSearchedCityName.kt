package com.el3sas.weatherApp.domain.usecaes

import com.el3sas.weatherApp.domain.repo.WeatherRepo
import javax.inject.Inject

class SaveLastSearchedCityName @Inject constructor(private val repo: WeatherRepo) {
    operator fun invoke(cityName: String) {
        repo.saveLastSearchedCityName(cityName)
    }
}