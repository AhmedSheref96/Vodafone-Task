package com.el3sas.domain.repo

import com.el3sas.domain.models.CurrentWeatherResponse
import com.el3sas.domain.models.WeatherFor7DaysResponse

interface WeatherRepo {

    suspend fun getCurrentWeather(lat: Double, lon: Double): CurrentWeatherResponse

    suspend fun getWeatherFor7Days(lat: Double, lon: Double): WeatherFor7DaysResponse

}