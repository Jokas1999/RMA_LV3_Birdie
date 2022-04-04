package com.example.lv3_zadatak.data

import androidx.room.OnConflictStrategy
import com.example.lv3_zadatak.model.Bird

interface BirdRepository {
    fun save(bird: Bird)
    fun delete(bird:Bird)
    fun getBirdById(id:Long) : Bird?
    fun getAllBirds() :List<Bird>

}