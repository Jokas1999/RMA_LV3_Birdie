package com.example.lv3_zadatak.utils

import android.widget.TimePicker
import java.sql.Time
import java.util.*

fun TimePicker.getTime() : Date{

    val calendar = Calendar.getInstance()
    calendar.set(0,0,0,hour,minute)
    return calendar.time
}