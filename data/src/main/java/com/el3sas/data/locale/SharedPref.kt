package com.el3sas.data.locale

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPref @Inject constructor(@ApplicationContext context: Context) {

    private val sharedPreference by lazy { context.getSharedPreferences("weatherPref", 0) }
    private val editor by lazy { sharedPreference.edit() }

    fun saveLastSearchedCityName(cityName: String) {
        editor.putString("cityName", cityName)
        editor.apply()
    }

    fun getLastSearchedCityName(): String? {
        return sharedPreference.getString("cityName", null)
    }

    fun clear() {
        editor.clear()
        editor.apply()
    }

}