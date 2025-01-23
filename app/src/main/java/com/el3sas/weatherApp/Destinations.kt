package com.el3sas.weatherApp

import com.el3sas.weatherApp.domain.models.CurrentWeatherResponse
import kotlinx.serialization.Serializable

@Serializable
sealed class Destinations {
    @Serializable
    data object InputCity : Destinations()

    @Serializable
    data class CurrentWeather(val weatherData: CurrentWeatherResponse) : Destinations()

    @Serializable
    data class WeatherForecast(val lat: Double, val lon: Double, val city: String) : Destinations()
}