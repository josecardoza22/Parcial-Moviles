package com.enrique.parcialmoviles.ui.plant.feed.RecycleView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.enrique.parcialmoviles.data.models.PlantModel
import com.enrique.parcialmoviles.databinding.PlantItemBinding

class RecycleViewAdapter (
    private val clickListener: (PlantModel) -> Unit) : RecyclerView.Adapter<RecycleViewHolder>() {
    private val plants = ArrayList<PlantModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        val binding = PlantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecycleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        val plant = plants[position]
        holder.bind(plant, clickListener)
    }

    override fun getItemCount(): Int {
        return plants.size
    }

    fun setData(productsList: List<PlantModel>) {
        plants.clear()
        plants.addAll(productsList)
    }

}