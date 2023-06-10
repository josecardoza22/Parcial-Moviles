package com.enrique.parcialmoviles

import com.enrique.parcialmoviles.data.plants
import com.enrique.parcialmoviles.repository.PlantRepository

class PlantReviewerApplication {
    val plantRepository: PlantRepository by lazy {
        PlantRepository(plants)
    }
}