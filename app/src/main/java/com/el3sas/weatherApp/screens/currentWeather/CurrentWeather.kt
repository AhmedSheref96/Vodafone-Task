package com.el3sas.weatherApp.screens.currentWeather

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.el3sas.weatherApp.domain.models.CurrentWeatherResponse
import com.el3sas.weatherApp.R
import com.el3sas.weatherApp.uiComponents.CurrentWeather

@Composable
fun CurrentWeatherScreen(
    modifier: Modifier = Modifier,
    currentWeather: CurrentWeatherResponse,
    openWeatherForecast: (lat: Double, lon: Double) -> Unit
) {
    ConstraintLayout(modifier = modifier) {
        val (details, weatherFor7days) = createRefs()
        CurrentWeather(modifier = Modifier.constrainAs(details) {
            top.linkTo(parent.top)
        }, currentWeather)
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(weatherFor7days) {
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            onClick = {
                openWeatherForecast(
                    currentWeather.coord?.lat ?: 0.0,
                    currentWeather.coord?.lon ?: 0.0
                )
            },
        ) {
            Text(
                text = stringResource(R.string.weather_forecast),
                textAlign = TextAlign.Center,
            )
        }
    }
}