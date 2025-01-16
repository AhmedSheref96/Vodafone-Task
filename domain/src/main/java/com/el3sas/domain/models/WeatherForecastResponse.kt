package com.el3sas.domain.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
import kotlinx.parcelize.Parcelize

@Parcelize
@Serializable
data class WeatherForecastResponse(

    @field:SerializedName("current")
    val current: Current? = null,

    @field:SerializedName("timezone")
    val timezone: String? = null,

    @field:SerializedName("timezone_offset")
    val timezoneOffset: Int? = null,

    @field:SerializedName("daily")
    val daily: List<DailyItem?>? = null,

    @field:SerializedName("lon")
    val lon: Double? = null,

    @field:SerializedName("minutely")
    val minutely: List<MinutelyItem?>? = null,

    @field:SerializedName("lat")
    val lat: Double? = null
) : Parcelable

@Parcelize
@Serializable
data class WeatherItem(

    @field:SerializedName("icon")
    val icon: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("main")
    val main: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
) : Parcelable

@Parcelize
@Serializable
data class FeelsLike(

    @field:SerializedName("eve")
    val eve: Double? = null,

    @field:SerializedName("night")
    val night: Double? = null,

    @field:SerializedName("day")
    val day: Double? = null,

    @field:SerializedName("morn")
    val morn: Double? = null
) : Parcelable

@Parcelize
@Serializable
data class Temp(

    @field:SerializedName("min")
    val min: Double? = null,

    @field:SerializedName("max")
    val max: Double? = null,

    @field:SerializedName("eve")
    val eve: Double? = null,

    @field:SerializedName("night")
    val night: Double? = null,

    @field:SerializedName("day")
    val day: Double? = null,

    @field:SerializedName("morn")
    val morn: Double? = null
) : Parcelable

@Parcelize
@Serializable
data class MinutelyItem(

    @field:SerializedName("dt")
    val dt: Int? = null,

    @field:SerializedName("precipitation")
    val precipitation: Int? = null
) : Parcelable

@Parcelize
@Serializable
data class Current(

    @field:SerializedName("sunrise")
    val sunrise: Int? = null,

    @field:SerializedName("temp")
    val temp: Double? = null,

    @field:SerializedName("visibility")
    val visibility: Int? = null,

    @field:SerializedName("uvi")
    val uvi: Double? = null,

    @field:SerializedName("pressure")
    val pressure: Int? = null,

    @field:SerializedName("clouds")
    val clouds: Int? = null,

    @field:SerializedName("feels_like")
    val feelsLike: Double? = null,

    @field:SerializedName("dt")
    val dt: Int? = null,

    @field:SerializedName("wind_deg")
    val windDeg: Int? = null,

    @field:SerializedName("dew_point")
    val dewPoint: Double? = null,

    @field:SerializedName("sunset")
    val sunset: Int? = null,

    @field:SerializedName("weather")
    val weather: List<WeatherItem?>? = null,

    @field:SerializedName("humidity")
    val humidity: Int? = null,

    @field:SerializedName("wind_speed")
    val windSpeed: Double? = null
) : Parcelable

@Parcelize
@Serializable
data class DailyItem(

    @field:SerializedName("moonset")
    val moonset: Int? = null,

    @field:SerializedName("summary")
    val summary: String? = null,

    @field:SerializedName("sunrise")
    val sunrise: Int? = null,

    @field:SerializedName("temp")
    val temp: Temp? = null,

    @field:SerializedName("moon_phase")
    val moonPhase: Double? = null,

    @field:SerializedName("uvi")
    val uvi: Double? = null,

    @field:SerializedName("moonrise")
    val moonrise: Int? = null,

    @field:SerializedName("pressure")
    val pressure: Int? = null,

    @field:SerializedName("clouds")
    val clouds: Int? = null,

    @field:SerializedName("feels_like")
    val feelsLike: FeelsLike? = null,

    @field:SerializedName("wind_gust")
    val windGust: Double? = null,

    @field:SerializedName("dt")
    val dt: Int? = null,

    @field:SerializedName("pop")
    val pop: Double? = null,

    @field:SerializedName("wind_deg")
    val windDeg: Int? = null,

    @field:SerializedName("dew_point")
    val dewPoint: Double? = null,

    @field:SerializedName("sunset")
    val sunset: Int? = null,

    @field:SerializedName("weather")
    val weather: List<WeatherItem?>? = null,

    @field:SerializedName("humidity")
    val humidity: Int? = null,

    @field:SerializedName("wind_speed")
    val windSpeed: Double? = null,

    @field:SerializedName("snow")
    val snow: Double? = null,

    @field:SerializedName("rain")
    val rain: Double? = null
) : Parcelable
