package com.el3sas.vodafone_task.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun formatUnixTime(unixTimestamp: Long, timezone: String): String {
    // Convert UNIX timestamp to Date object (timestamp is in seconds, so multiply by 1000 to get milliseconds)
    val date = Date(unixTimestamp * 1000)

    // Create a SimpleDateFormat to define the output format
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)

    // Set the time zone for the formatter
    val timeZone = TimeZone.getTimeZone(timezone)
    sdf.timeZone = timeZone

    return sdf.format(date)
}

@SuppressLint("DefaultLocale")
fun formatUnixTime(unixTimestamp: Long, timezoneOffset: Int): String {
    val date = Date(unixTimestamp * 1000) // Convert to milliseconds
    val sdf = SimpleDateFormat("HH:mm:ss", Locale.ENGLISH)

    // Convert the timezone offset from seconds to hours and minutes
    val offsetInHours = timezoneOffset / 3600
    val offsetInMinutes = (timezoneOffset % 3600) / 60
    val timeZone = TimeZone.getTimeZone(
        "GMT${if (offsetInHours >= 0) "+" else ""}${offsetInHours}:${
            String.format(
                "%02d",
                offsetInMinutes
            )
        }"
    )

    sdf.timeZone = timeZone
    return sdf.format(date)
}
