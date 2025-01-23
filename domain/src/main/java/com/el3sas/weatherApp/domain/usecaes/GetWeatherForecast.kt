package com.el3sas.weatherApp.domain.usecaes

import com.el3sas.weatherApp.domain.models.WeatherForecastResponse
import com.el3sas.weatherApp.domain.repo.WeatherRepo
import javax.inject.Inject

class GetWeatherForecast @Inject constructor(private val repo: WeatherRepo) {

    suspend operator fun invoke(
        lat: Double,
        lon: Double,
        onCatchException: (Throwable) -> Unit
    ): WeatherForecastResponse? {
        return repo.getWeatherForecast(lat = lat, lon = lon).getOrElse { exception ->
            onCatchException(exception)
            null
        }
    }
}