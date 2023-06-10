package com.enrique.parcialmoviles.ui.plant.newplant

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.enrique.parcialmoviles.data.models.PlantModel
import com.enrique.parcialmoviles.databinding.FragmentNewPlantBinding
import com.enrique.parcialmoviles.databinding.PlantItemBinding
import com.enrique.parcialmoviles.ui.plant.viewmodel.PlantViewModel

class NewProductFragment : Fragment() {

    private lateinit var binding: FragmentNewPlantBinding

    private val viewModel: PlantViewModel by activityViewModels {
        PlantViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewPlantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        setObserver()
    }

    private fun setViewModel(){
        binding.viewmodel = viewModel
    }

    private fun setObserver() {
        viewModel.status.observe(viewLifecycleOwner){status ->
            when {
                status.equals(PlantViewModel.PRODUCT_CREATE) -> {
                    Log.d("TAG APP", status)
                    Log.d("TAG APP", viewModel.getPlants().toString())

                    viewModel.clearStatus()
                    viewModel.clearData()

                    findNavController().popBackStack()
                }
                status.equals(PlantViewModel.WRONG_DATA) -> {
                    Log.d("APP TAP", status)
                    viewModel.clearStatus()
                }
            }
        }
    }

}