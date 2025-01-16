package com.el3sas.domain.usecaes

import com.el3sas.domain.models.CurrentWeatherResponse
import com.el3sas.domain.repo.WeatherRepo
import javax.inject.Inject

class GetCurrentWeather @Inject constructor(private val repo: WeatherRepo) {
    suspend operator fun invoke(
        cityName: String, onCatchException: (Throwable) -> Unit
    ): CurrentWeatherResponse? {
        repo.getCurrentWeather(cityName = cityName)
            .getOrElse { exception -> onCatchException(exception) }.let { any ->
                return any as? CurrentWeatherResponse
            }
    }
}