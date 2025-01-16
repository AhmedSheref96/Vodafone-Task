package com.el3sas.vodafone_task.uiComponents

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.el3sas.domain.models.CurrentWeatherResponse
import com.el3sas.vodafone_task.R
import com.el3sas.vodafone_task.utils.formatUnixTime

@Composable
fun CurrentWeather(modifier: Modifier,weatherData: CurrentWeatherResponse) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (city, description, temp, minMaxTemp, wind, humidity, clouds, visibility, sunriseSunset, icon) = createRefs()

        Text(
            text = stringResource(
                R.string.city_country,
                weatherData.name.toString(),
                weatherData.sys?.country.toString()
            ),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.constrainAs(city) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }
        )

        Text(
            text = stringResource(
                R.string.weather_description,
                weatherData.weather?.get(0)?.main.toString(),
                weatherData.weather?.get(0)?.description.toString()
            ),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.constrainAs(description) {
                top.linkTo(city.bottom, margin = 8.dp)
                start.linkTo(parent.start)
            }
        )

        Text(
            text = stringResource(
                R.string.temperature,
                weatherData.main?.temp.toString(),
                weatherData.main?.feelsLike.toString()
            ),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.constrainAs(temp) {
                top.linkTo(description.bottom, margin = 12.dp)
                start.linkTo(parent.start)
            }
        )

        Text(
            text = stringResource(
                R.string.min_max_temperature,
                weatherData.main?.tempMin.toString(),
                weatherData.main?.tempMax.toString()
            ),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.constrainAs(minMaxTemp) {
                top.linkTo(temp.bottom, margin = 8.dp)
                start.linkTo(parent.start)
            }
        )

        Text(
            text = stringResource(
                R.string.wind,
                weatherData.wind?.speed.toString(),
                windDirection(weatherData.wind!!.deg!!)
            ),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.constrainAs(wind) {
                top.linkTo(minMaxTemp.bottom, margin = 8.dp)
                start.linkTo(parent.start)
            }
        )

        Text(
            text = stringResource(
                R.string.humidity_pressure,
                weatherData.main?.humidity.toString(),
                weatherData.main?.pressure.toString()
            ),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.constrainAs(humidity) {
                top.linkTo(wind.bottom, margin = 8.dp)
                start.linkTo(parent.start)
            }
        )

        Text(
            text = stringResource(R.string.cloudiness, weatherData.clouds?.all.toString()),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.constrainAs(clouds) {
                top.linkTo(humidity.bottom, margin = 8.dp)
                start.linkTo(parent.start)
            }
        )

        Text(
            text = stringResource(R.string.visibility, weatherData.visibility?.div(1000) ?: ""),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.constrainAs(visibility) {
                top.linkTo(clouds.bottom, margin = 8.dp)
                start.linkTo(parent.start)
            }
        )

        Text(
            text = stringResource(
                R.string.sunrise_sunset,
                formatUnixTime(weatherData.sys?.sunrise!!.toLong(), weatherData.timezone!!),
                formatUnixTime(weatherData.sys?.sunset!!.toLong(), weatherData.timezone!!)
            ),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.constrainAs(sunriseSunset) {
                top.linkTo(visibility.bottom, margin = 8.dp)
                start.linkTo(parent.start)
            }
        )
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(
                    stringResource(
                        id = R.string.weather_icon,
                        weatherData.weather?.get(0)?.icon ?: ""
                    )
                )
                .crossfade(true)
                .build(),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(128.dp)
                .constrainAs(icon) {
                    top.linkTo(city.bottom, margin = 16.dp)
                    end.linkTo(parent.end)
                },
        )


    }


}

fun windDirection(deg: Int): String {
    val directions = arrayOf("N", "NE", "E", "SE", "S", "SW", "W", "NW")
    return directions[((deg / 45) % 8)]
}
