package com.el3sas.vodafone_task.screens.cityInput

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.el3sas.domain.models.CurrentWeatherResponse
import com.el3sas.vodafone_task.R

@Composable
fun CityInputRoute(
    modifier: Modifier = Modifier,
    onCitySelected: (CurrentWeatherResponse) -> Unit
) {
    val viewModel: CityInputViewModel = hiltViewModel()
    val lastSelectedCityName = viewModel.lastSelectedCityName
    val currentWeather by viewModel.currentWeather.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()

    if (currentWeather != null) onCitySelected.invoke(currentWeather!!)

    CityInputScreen(
        currentWeather = currentWeather, error = error,
        lastSelectedCityName = lastSelectedCityName,
        onCitySelected = {
            viewModel.getCurrentWeather(it)
        },
    )
}

@Composable
fun CityInputScreen(
    modifier: Modifier = Modifier,
    lastSelectedCityName: String?,
    currentWeather: CurrentWeatherResponse? = null,
    error: Throwable? = null,
    onCitySelected: (String) -> Unit,
) {

    var cityName by rememberSaveable { mutableStateOf(lastSelectedCityName ?: "") }
    var isCityNameError by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = modifier.then(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = cityName,
            onValueChange = { cityName = it },
            label = { Text(stringResource(id = R.string.city_name)) },
            isError = isCityNameError,
            trailingIcon = {
                if (isCityNameError) Icon(Icons.Default.Warning, contentDescription = "Error Icon")
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextButton(
            onClick = {
                onCitySelected.invoke(cityName)
            }
        ) {
            Text(stringResource(R.string.submmit))
        }

        if (error != null && currentWeather != null) {
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp), text = error.message ?: "",
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )
        }
    }
}