package com.example.lv3_zadatak.utils

import android.widget.DatePicker
import java.sql.Time
import java.time.DayOfWeek
import java.util.*

fun DatePicker.getDate(): Date {
    val calendar = Calendar.getInstance()
    calendar.set(year,month,dayOfMonth,)

    return calendar.time
}

