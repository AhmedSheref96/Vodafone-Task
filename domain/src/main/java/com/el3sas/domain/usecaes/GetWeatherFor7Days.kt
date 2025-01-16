package com.el3sas.domain.usecaes

import com.el3sas.domain.models.WeatherFor7DaysResponse
import com.el3sas.domain.repo.WeatherRepo
import javax.inject.Inject

class GetWeatherFor7Days @Inject constructor(private val repo: WeatherRepo) {

    suspend operator fun invoke(
        lat: Double,
        lon: Double,
        onCatchException: (Throwable) -> Unit
    ): WeatherFor7DaysResponse? {
        return repo.getWeatherFor7Days(lat = lat, lon = lon).getOrElse { exception ->
            onCatchException(exception)
            null
        }
    }
}