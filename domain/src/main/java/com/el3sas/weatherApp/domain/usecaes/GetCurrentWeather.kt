package com.el3sas.weatherApp.domain.usecaes

import com.el3sas.weatherApp.domain.models.CurrentWeatherResponse
import com.el3sas.weatherApp.domain.repo.WeatherRepo
import javax.inject.Inject

class GetCurrentWeather @Inject constructor(private val repo: WeatherRepo) {
    suspend operator fun invoke(
        cityName: String
    ): Result<CurrentWeatherResponse> =
        repo.getCurrentWeather(cityName = cityName)

}