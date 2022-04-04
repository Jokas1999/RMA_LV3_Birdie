package com.example.lv3_zadatak.data

import androidx.room.*
import com.example.lv3_zadatak.model.Bird

@Dao
interface BirdDao {
     @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun save(bird:Bird)

     @Delete
     fun delete(bird:Bird)

     @Query("SELECT * FROM birds WHERE id=:id")
     fun getBirdById(id:Long) : Bird?

     @Query("SELECT * FROM birds")
     fun getAllBirds() :List<Bird>

}