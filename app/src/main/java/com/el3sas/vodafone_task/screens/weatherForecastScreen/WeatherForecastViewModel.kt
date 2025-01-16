package com.el3sas.vodafone_task.screens.weatherForecastScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.el3sas.domain.usecaes.GetWeatherForecast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherForecastViewModel @Inject constructor(
    private val getWeatherForecast: GetWeatherForecast
) : ViewModel() {
    private val _weatherForecast =
        MutableStateFlow<WeatherForcestStates>(WeatherForcestStates.Loading)
    val weatherForecast = _weatherForecast.asStateFlow()


    private fun handleActions(action: WeatherForecastActions) {
        when (action) {
            is WeatherForecastActions.GetWeatherForecast -> getWeatherForecast(
                action.lat,
                action.lon
            )

        }
    }

    private fun getWeatherForecast(lat: Double, lon: Double) {
        viewModelScope.launch {
            val weatherForecast = getWeatherForecast(lat, lon) { throwable ->
                _weatherForecast.value = WeatherForcestStates.ShowError(throwable)
            }
            weatherForecast?.let {
                _weatherForecast.value = WeatherForcestStates.WeatherForecast(it)
            }
        }
    }

    fun sendAction(action: WeatherForecastActions) = viewModelScope.launch {
        handleActions(action)
    }
}