package com.enrique.parcialmoviles.repository

import com.enrique.parcialmoviles.data.models.PlantModel

class PlantRepository(private val plants: MutableList<PlantModel>) {
    fun getPlants() = plants

    fun addPlant(newPlant: PlantModel) = plants.add(newPlant)
}