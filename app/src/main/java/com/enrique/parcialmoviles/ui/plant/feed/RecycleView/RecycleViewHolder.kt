package com.enrique.parcialmoviles.ui.plant.feed.RecycleView

import androidx.recyclerview.widget.RecyclerView
import com.enrique.parcialmoviles.data.models.PlantModel
import com.enrique.parcialmoviles.data.plants
import com.enrique.parcialmoviles.databinding.PlantItemBinding

class RecycleViewHolder(private val binding: PlantItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(plant: PlantModel, clickListener: (PlantModel) -> Unit) {
        binding.namePlant.text = plant.type
        binding.colorPlant.text = plant.color

        binding.plantCard.setOnClickListener{
            clickListener(plant)
        }
    }
}