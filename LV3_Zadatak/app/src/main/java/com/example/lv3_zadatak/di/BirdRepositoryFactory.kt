package com.example.lv3_zadatak.di

import com.example.lv3_zadatak.Birdie
import com.example.lv3_zadatak.data.BirdRepository
import com.example.lv3_zadatak.data.BirdRepositoryImpl
import room.BirdDatabase

object BirdRepositoryFactory {
    val roomDb = BirdDatabase.getDatabase(Birdie.application)
    val birdRepository : BirdRepository =BirdRepositoryImpl(roomDb.getBirdDao())
}