package com.el3sas.weatherApp.domain.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class CurrentWeatherResponse(

    @field:SerializedName("visibility")
    val visibility: Int? = null,

    @field:SerializedName("timezone")
    val timezone: Int? = null,

    @field:SerializedName("main")
    val main: Main? = null,

    @field:SerializedName("clouds")
    val clouds: Clouds? = null,

    @field:SerializedName("sys")
    val sys: Sys? = null,

    @field:SerializedName("dt")
    val dt: Int? = null,

    @field:SerializedName("coord")
    val coord: Coord? = null,

    @field:SerializedName("weather")
    val weather: List<WeatherItem?>? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("cod")
    val cod: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("base")
    val base: String? = null,

    @field:SerializedName("wind")
    val wind: Wind? = null
) : Parcelable

@Parcelize
@Serializable
data class Clouds(

    @field:SerializedName("all")
    val all: Int? = null
) : Parcelable

@Parcelize
@Serializable
data class Wind(

    @field:SerializedName("deg")
    val deg: Int? = null,

    @field:SerializedName("speed")
    val speed: Double? = null
) : Parcelable

@Parcelize
@Serializable
data class Main(

    @field:SerializedName("temp")
    val temp: Double? = null,

    @field:SerializedName("temp_min")
    val tempMin: Double? = null,

    @field:SerializedName("grnd_level")
    val grndLevel: Int? = null,

    @field:SerializedName("humidity")
    val humidity: Int? = null,

    @field:SerializedName("pressure")
    val pressure: Int? = null,

    @field:SerializedName("sea_level")
    val seaLevel: Int? = null,

    @field:SerializedName("feels_like")
    val feelsLike: Double? = null,

    @field:SerializedName("temp_max")
    val tempMax: Double? = null
) : Parcelable

@Parcelize
@Serializable
data class Coord(

    @field:SerializedName("lon")
    val lon: Double? = null,

    @field:SerializedName("lat")
    val lat: Double? = null
) : Parcelable

@Parcelize
@Serializable
data class Sys(

    @field:SerializedName("country")
    val country: String? = null,

    @field:SerializedName("sunrise")
    val sunrise: Int? = null,

    @field:SerializedName("sunset")
    val sunset: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("type")
    val type: Int? = null
) : Parcelable
