package com.el3sas.weatherApp.screens.cityInput

import com.el3sas.weatherApp.domain.usecaes.GetCurrentWeather

sealed class Directions {
    data object CityInput : Directions()
    data class WeatherDetails(val currentWeather: GetCurrentWeather) : Directions()
    data object WeatherFor7Days : Directions()
}