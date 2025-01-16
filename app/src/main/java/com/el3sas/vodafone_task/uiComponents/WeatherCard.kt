package com.el3sas.vodafone_task.uiComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.el3sas.domain.models.DailyItem
import com.el3sas.vodafone_task.R


@Composable
fun WeatherDayCard(modifier: Modifier = Modifier, day: DailyItem) {
    Card(
        modifier = modifier
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AsyncImage(
                model = stringResource(R.string.weather_icon, day.weather?.get(0)?.icon.toString()),
                contentDescription = stringResource(R.string.weather_icon_desc),
                modifier = Modifier.size(48.dp)
            )

            Text(
                text = stringResource(
                    R.string.temperature,
                    day.temp?.day.toString(),
                    day.temp?.night.toString(),
                ),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}