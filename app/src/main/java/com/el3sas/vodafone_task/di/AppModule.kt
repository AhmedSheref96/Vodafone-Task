package com.el3sas.vodafone_task.di

import com.el3sas.data.repo.WeatherRepoImpl
import com.el3sas.domain.repo.WeatherRepo
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