package com.el3sas.weatherApp.data.repo

import com.el3sas.weatherApp.data.locale.SharedPref
import com.el3sas.weatherApp.data.remote.WeatherApis
import com.el3sas.weatherApp.domain.repo.WeatherRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepoImpl @Inject constructor(
    private val api: WeatherApis,
    private val sharedPref: SharedPref
) : WeatherRepo {

    override suspend fun getCurrentWeather(cityName: String) =
        withContext(Dispatchers.IO) {
            runCatching { api.getCurrentWeather(cityName) }
        }

    override suspend fun getWeatherForecast(lat: Double, lon: Double) =
        withContext(Dispatchers.IO) {
            runCatching { api.getWeatherFor7Days(lat, lon) }
        }

    override fun saveLastSearchedCityName(cityName: String) {
        sharedPref.saveLastSearchedCityName(cityName)
    }

    override fun getLastSelectedCityName(): String? = sharedPref.getLastSearchedCityName()

}