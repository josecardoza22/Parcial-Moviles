package com.enrique.parcialmoviles.ui.plant.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.enrique.parcialmoviles.R
import com.enrique.parcialmoviles.data.models.PlantModel
import com.enrique.parcialmoviles.databinding.FragmentFeedBinding
import com.enrique.parcialmoviles.ui.plant.feed.RecycleView.RecycleViewAdapter
import com.enrique.parcialmoviles.ui.plant.viewmodel.PlantViewModel

class FeedFragment : Fragment() {

    private lateinit var binding: FragmentFeedBinding
    private lateinit var adapter: RecycleViewAdapter

    private val viewModel: PlantViewModel by activityViewModels {
        PlantViewModel.Factory
    }

    private fun showSelectedPlant(plant: PlantModel) {
        viewModel.setSelectedPlant(plant)
        findNavController().navigate(R.id.action_feedFragment_to_viewPlantFragment)
    }

    private fun displayProducts(){
        adapter.setData(viewModel.getPlants())
        adapter.notifyDataSetChanged()
    }

    private fun setRecycleView(view: View){
        binding.productRecycleview.layoutManager = LinearLayoutManager(view.context)

        adapter = RecycleViewAdapter { selectedPlant ->
            showSelectedPlant(selectedPlant)
        }

        binding.productRecycleview.adapter = adapter
        displayProducts()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecycleView(view)

        binding.actionToCreatePlant.setOnClickListener{
            viewModel.clearData()
            findNavController().navigate(R.id.actionToCreatePlant)
        }
    }
}