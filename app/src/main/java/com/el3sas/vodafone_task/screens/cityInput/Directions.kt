package com.el3sas.vodafone_task.screens.cityInput

import com.el3sas.domain.usecaes.GetCurrentWeather

sealed class Directions {
    data object CityInput : Directions()
    data class WeatherDetails(val currentWeather: GetCurrentWeather) : Directions()
    data object WeatherFor7Days : Directions()
}