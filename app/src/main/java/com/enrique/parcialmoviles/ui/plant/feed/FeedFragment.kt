package com.enrique.parcialmoviles.ui.plant.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.enrique.parcialmoviles.R
import com.enrique.parcialmoviles.databinding.FragmentFeedBinding
import com.enrique.parcialmoviles.ui.plant.feed.RecycleView.RecycleViewAdapter

class FeedFragment : Fragment() {

    private lateinit var binding: FragmentFeedBinding
    private lateinit var adapter: RecycleViewAdapter

    private val viewModel: PlantViewModel by activityViewModels {
        PlantViewModel.Factory
    }

    private fun showSelectedProduct(product: ProductModel) {
        viewModel.setSelectedProduct(product)
        findNavController().navigate(R.id.action_feedFragment_to_viewProductFragment)
    }

    private fun displayProducts(){
        adapter.setData(viewModel.getProducts())
        adapter.notifyDataSetChanged()
    }

    private fun setRecycleView(view: View){
        binding.productRecycleview.layoutManager = LinearLayoutManager(view.context)

        adapter = ProductRecycleViewAdapter { selectedProduct ->
            showSelectedProduct(selectedProduct)
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

        binding.actionToCreateProduct.setOnClickListener{
            viewModel.clearData()
            findNavController().navigate(R.id.action_feedFragment_to_newProductFragment)
        }
    }
}