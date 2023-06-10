package com.enrique.parcialmoviles.ui.plant.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.enrique.parcialmoviles.PlantReviewerApplication
import com.enrique.parcialmoviles.data.models.PlantModel
import com.enrique.parcialmoviles.data.type
import com.enrique.parcialmoviles.repository.PlantRepository

class PlantViewModel(private val repository: PlantRepository): ViewModel() {
    var type: MutableLiveData<String> = MutableLiveData("")
    var color = MutableLiveData("")
    var status = MutableLiveData("")

    fun getPlants() = repository.getPlants()

    fun addPlant(plant: PlantModel) = repository.addPlant(plant)

    private fun validateData(): Boolean{
        when {
            type.value.isNullOrEmpty() -> return false
            color.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun createPlant() {

        if(!validateData()){
            status.value = WRONG_DATA
            return
        }
        val newPlant = PlantModel(
            type.value.toString(),
            color.value.toString(),
        )

        addPlant(newPlant)
        status.value = PRODUCT_CREATE
    }

    fun clearData() {
        type.value = ""
        color.value = ""
    }

    fun clearStatus() {
        status.value = BASE_STATE
    }

    fun setSelectedPlant (plant: PlantModel){
        type.value = plant.type
        color.value = plant.color
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {

                val app = this[APPLICATION_KEY] as PlantReviewerApplication
                PlantViewModel(app.plantRepository)
            }
        }
        const val PRODUCT_CREATE = "Planta Creado"
        const val WRONG_DATA = "Wrong Data"
        const val BASE_STATE = ""
    }
}