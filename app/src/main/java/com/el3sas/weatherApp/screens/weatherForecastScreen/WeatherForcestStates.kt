package com.el3sas.weatherApp.screens.weatherForecastScreen

import com.el3sas.weatherApp.domain.models.WeatherForecastResponse

sealed class WeatherForcestStates {
    object Loading : WeatherForcestStates()
    data class WeatherForecast(val weatherForecast: WeatherForecastResponse) : WeatherForcestStates()
    data class ShowError(val throwable: Throwable? = null) : WeatherForcestStates()
}