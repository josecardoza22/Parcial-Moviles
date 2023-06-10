package com.enrique.parcialmoviles.repository

import com.enrique.parcialmoviles.data.models.PlantModel

class PlantRepository(private val plants: MutableList<PlantModel>) {
    fun getProducts() = plants

    fun addProducts(newPlant: PlantModel) = plants.add(newPlant)
}