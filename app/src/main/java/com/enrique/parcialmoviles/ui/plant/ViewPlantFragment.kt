package com.enrique.parcialmoviles.ui.plant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.enrique.parcialmoviles.databinding.FragmentViewPlantBinding
import com.enrique.parcialmoviles.ui.plant.viewmodel.PlantViewModel

class ViewProductFragment : Fragment() {

    private lateinit var binding: FragmentViewPlantBinding

    private val viewModel : PlantViewModel by activityViewModels {
        PlantViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPlantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel(){
        binding.viewmodel = viewModel
    }

}