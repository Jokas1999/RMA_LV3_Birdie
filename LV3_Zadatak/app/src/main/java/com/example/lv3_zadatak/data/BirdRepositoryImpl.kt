package com.example.lv3_zadatak.data

import com.example.lv3_zadatak.model.Bird

class BirdRepositoryImpl(val birddao:BirdDao):BirdRepository {
    override fun save(bird: Bird) {
        birddao.save(bird)
    }

    override fun delete(bird: Bird) {
        birddao.delete(bird)
        }

    override fun getBirdById(id: Long): Bird? = birddao.getBirdById(id)


    override fun getAllBirds(): List<Bird> {
        return birddao.getAllBirds()
    }
}