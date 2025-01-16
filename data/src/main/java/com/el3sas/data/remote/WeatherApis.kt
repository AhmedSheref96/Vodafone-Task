package com.el3sas.data.remote

import com.el3sas.domain.models.CurrentWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApis {

    @GET(Constants.baseUrl.plus(Constants.currentWeather))
    suspend fun getCurrentWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String = Constants.apiKey,
        @Query("units") units: String = "metric"
    ): CurrentWeatherResponse

    @GET(Constants.baseUrl.plus(Constants.weatherFor7Days))
    suspend fun getWeatherFor7Days(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("exclude") exclude: String = "minutely,hourly,alerts",
        @Query("units") units: String = "metric",
        @Query("appid") apiKey: String = Constants.apiKey
    ): CurrentWeatherResponse

}