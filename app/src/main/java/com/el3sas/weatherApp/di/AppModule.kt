package com.el3sas.weatherApp.di

import com.el3sas.weatherApp.data.repo.WeatherRepoImpl
import com.el3sas.weatherApp.domain.repo.WeatherRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindWeatherRepository(weatherRepositoryImpl: WeatherRepoImpl): WeatherRepo

}