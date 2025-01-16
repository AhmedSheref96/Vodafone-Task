package com.el3sas.vodafone_task.screens.weatherForecastScreen

sealed class WeatherForecastActions {
    data class GetWeatherForecast(val lat: Double, val lon: Double) : WeatherForecastActions()
}