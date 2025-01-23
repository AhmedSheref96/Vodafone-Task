package com.el3sas.domain.repo

import com.el3sas.domain.models.CurrentWeatherResponse
import com.el3sas.domain.models.WeatherForecastResponse

interface WeatherRepo {

    suspend fun getCurrentWeather(cityName:String): Result<CurrentWeatherResponse>

    suspend fun getWeatherForecast(lat: Double, lon: Double): Result<WeatherForecastResponse>

    fun saveLastSearchedCityName(cityName: String)

    fun getLastSelectedCityName():String?

}