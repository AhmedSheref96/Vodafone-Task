package com.el3sas.weatherApp.data.di

import com.el3sas.weatherApp.data.remote.Constants
import com.el3sas.weatherApp.data.remote.WeatherApis
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Singleton
    @Provides
    fun provideWeatherApi(retrofit: Retrofit): WeatherApis {
        return retrofit.create(WeatherApis::class.java)
    }

}