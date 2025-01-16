package com.el3sas.data.repo

import com.el3sas.data.locale.SharedPref
import com.el3sas.data.remote.WeatherApis
import com.el3sas.domain.repo.WeatherRepo
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

    override suspend fun getWeatherFor7Days(lat: Double, lon: Double) =
        withContext(Dispatchers.IO) {
            runCatching { api.getWeatherFor7Days(lat, lon) }
        }

    override suspend fun saveLastSearchedCityName(cityName: String) = withContext(Dispatchers.IO) {
        runCatching { sharedPref.saveLastSearchedCityName(cityName) }
    }

}