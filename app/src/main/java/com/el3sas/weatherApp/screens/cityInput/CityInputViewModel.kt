package com.el3sas.weatherApp.screens.cityInput

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.el3sas.weatherApp.domain.models.CurrentWeatherResponse
import com.el3sas.weatherApp.domain.usecaes.GetCurrentWeather
import com.el3sas.weatherApp.domain.usecaes.GetLastSelectedCityName
import com.el3sas.weatherApp.domain.usecaes.SaveLastSearchedCityName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityInputViewModel @Inject constructor(
    private val gettingCurrentWeather: GetCurrentWeather,
    private val getLastSelectedCityName: GetLastSelectedCityName,
    private val saveLastSearchedCityName: SaveLastSearchedCityName
) : ViewModel() {

    private val _lastSelectedCityName = MutableStateFlow<String>("")
    val lastSelectedCityName = _lastSelectedCityName.asStateFlow()

    private val _currentWeather = MutableStateFlow<CurrentWeatherResponse?>(null)
    val currentWeather = _currentWeather.asStateFlow()

    private val _error = MutableStateFlow<Throwable?>(null)
    val error = _error.asStateFlow()

    init {
        viewModelScope.launch {
            _lastSelectedCityName.tryEmit(getLastSelectedCityName() ?: "")
        }
    }

    fun getCurrentWeather(cityName: String) = viewModelScope.async {
        gettingCurrentWeather(cityName = cityName).onSuccess {
            _currentWeather.tryEmit(it)
            saveLastSearchedCityName(cityName)
        }.onFailure {
            _error.tryEmit(it)
        }.getOrNull()
    }

    fun clearCurrentData() = viewModelScope.launch {
        _currentWeather.tryEmit(null)
    }
}