package com.el3sas.vodafone_task.screens.weatherForecastScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.el3sas.vodafone_task.R
import com.el3sas.vodafone_task.uiComponents.WeatherDayCard

@Composable
fun WeatherForecastRoute(modifier: Modifier = Modifier, lon: Double, lat: Double) {
    val viewModel: WeatherForecastViewModel = hiltViewModel()
    val weatherForecast by viewModel.weatherForecast.collectAsStateWithLifecycle()
    viewModel.sendAction(WeatherForecastActions.GetWeatherForecast(lon, lat))
    WeatherForecastScreen(modifier = modifier, weatherData = weatherForecast)
}

@Composable
fun WeatherForecastScreen(modifier: Modifier = Modifier, weatherData: WeatherForcestStates) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.weather_forecast),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        when (weatherData) {
            is WeatherForcestStates.Loading -> {
                Text(text = stringResource(R.string.loading))
            }

            is WeatherForcestStates.ShowError -> {
                Text(text = weatherData.throwable?.message ?: "error occurred!")
            }

            is WeatherForcestStates.WeatherForecast -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    itemsIndexed(
                        weatherData.weatherForecast.daily?.filterNotNull() ?: emptyList()
                    ) { index, day ->
                        WeatherDayCard(
                            modifier = Modifier.fillMaxWidth(),
                            day = day
                        )
                    }
                }
            }
        }
    }
}
