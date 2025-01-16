package com.el3sas.domain.repo

import com.el3sas.domain.models.CurrentWeatherResponse
import com.el3sas.domain.models.WeatherFor7DaysResponse

interface WeatherRepo {

    suspend fun getCurrentWeather(cityName:String): Result<CurrentWeatherResponse>

    suspend fun getWeatherFor7Days(lat: Double, lon: Double): Result<WeatherFor7DaysResponse>

    suspend fun saveLastSearchedCityName(cityName: String): Result<Unit>

}