package com.el3sas.vodafone_task.screens.cityInput

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.el3sas.domain.models.CurrentWeatherResponse
import com.el3sas.domain.usecaes.GetCurrentWeather
import com.el3sas.domain.usecaes.GetLastSelectedCityName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityInputViewModel @Inject constructor(
    private val getCurrentWeather: GetCurrentWeather,
    private val getLastSelectedCityName: GetLastSelectedCityName
) : ViewModel() {

    val lastSelectedCityName = getLastSelectedCityName()

    private val _currentWeather = MutableStateFlow<CurrentWeatherResponse?>(null)
    val currentWeather = _currentWeather.asStateFlow()

    private val _error = MutableStateFlow<Throwable?>(null)
    val error = _error.asStateFlow()

    fun getCurrentWeather(cityName: String) = viewModelScope.launch {
        getCurrentWeather(cityName = cityName, onCatchException = { throwable ->
            _error.tryEmit(throwable)
        })?.let { currentWeather ->
            _currentWeather.tryEmit(currentWeather)
        }
    }

    fun clearCurrentData() = viewModelScope.launch {
        _currentWeather.tryEmit(null)
    }
}