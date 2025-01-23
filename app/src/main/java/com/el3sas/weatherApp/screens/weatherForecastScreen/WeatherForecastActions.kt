package com.el3sas.weatherApp.screens.weatherForecastScreen

sealed class WeatherForecastActions {
    data class GetWeatherForecast(val lat: Double, val lon: Double) : WeatherForecastActions()
}