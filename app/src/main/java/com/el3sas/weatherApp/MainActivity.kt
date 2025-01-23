package com.el3sas.weatherApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.el3sas.weatherApp.domain.models.CurrentWeatherResponse
import com.el3sas.weatherApp.Destinations.CurrentWeather
import com.el3sas.weatherApp.Destinations.InputCity
import com.el3sas.weatherApp.Destinations.WeatherForecast
import com.el3sas.weatherApp.screens.cityInput.CityInputRoute
import com.el3sas.weatherApp.screens.currentWeather.CurrentWeatherScreen
import com.el3sas.weatherApp.screens.weatherForecastScreen.WeatherForecastRoute
import com.el3sas.weatherApp.ui.theme.VodafoneTaskTheme
import com.el3sas.weatherApp.utils.navType
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.typeOf

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VodafoneTaskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navHostController = rememberNavController()
                    NavHost(modifier = Modifier.padding(innerPadding), navHostController)
                }
            }
        }
    }
}

@Composable
fun NavHost(modifier: Modifier, navHostController: NavHostController) {
    NavHost(navHostController, startDestination = InputCity) {
        composable<InputCity>(
            mapOf(
                typeOf<CurrentWeatherResponse>() to navType<CurrentWeatherResponse>(serializer = CurrentWeatherResponse.serializer()),
            ),
        ) {
            CityInputRoute(modifier = modifier) {
                navHostController.navigate(CurrentWeather(weatherData = it))
            }
        }

        composable<CurrentWeather>(
            mapOf(
                typeOf<CurrentWeatherResponse>() to navType<CurrentWeatherResponse>(serializer = CurrentWeatherResponse.serializer()),
            ),
        ) {
            val weatherData = it.toRoute<CurrentWeather>()
            CurrentWeatherScreen(
                modifier = modifier,
                currentWeather = weatherData.weatherData
            ) { lat, lon ->
                navHostController.navigate(
                    WeatherForecast(
                        city = weatherData.weatherData.name ?: "", lat = lat, lon = lon
                    )
                )
            }
        }

        composable<WeatherForecast> {
            val lat = it.arguments?.getDouble("lat")
            val lon = it.arguments?.getDouble("lon")
            WeatherForecastRoute(modifier = modifier, lon = lon ?: 0.0, lat = lat ?: 0.0)
        }

    }
}