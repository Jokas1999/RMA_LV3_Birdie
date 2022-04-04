package com.example.lv3_zadatak.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*

@Entity(tableName = "birds")
data class Bird(
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0,
    @ColumnInfo(name="color")
    var colour : String,
    @ColumnInfo(name="date")
    var date : Date,
    @ColumnInfo(name="place")
    var place : String,
    @ColumnInfo(name="time")
    var time : Date,
    @ColumnInfo(name="name")
    var name : String
)