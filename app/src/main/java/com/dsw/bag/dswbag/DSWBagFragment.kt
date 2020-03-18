package com.dsw.bag.dswbag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dsw.bag.dswbag.adapters.ProductsAdapter
import com.dsw.bag.dswbag.adapters.PromosAdapter
import com.dsw.bag.dswbag.databinding.FragmentDswBagfragmentBinding
import com.dsw.bag.dswbag.model.Product
import com.dsw.bag.dswbag.model.Promo
import com.dsw.bag.dswbag.repository.RepositoryImpl
import com.dsw.bag.dswbag.viewmodel.MainViewModel
import com.dsw.bag.dswbag.viewmodel.ViewModelFactory
import java.util.*


class DSWBagFragment : Fragment() {
    private var productAdapter: ProductsAdapter? = null
    private var promosAdapter: PromosAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDswBagfragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_dsw_bagfragment, container, false)
        val viewModelFactory = ViewModelFactory(RepositoryImpl())
        activity?.let {
            val viewModel =
                ViewModelProviders.of(it, viewModelFactory).get(MainViewModel::class.java)
            viewModel.bagInfo(context!!.cacheDir)
            binding.bag = viewModel.bussinesObject.value

            // bind RecyclerView
            val linearLayoutManager = LinearLayoutManager(context)
            linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
            val productRecyclerView: RecyclerView = binding.productsContainer
            productRecyclerView.layoutManager = LinearLayoutManager(context)
            productRecyclerView.setHasFixedSize(true)
            productAdapter = ProductsAdapter()
            productRecyclerView.adapter = productAdapter
            productAdapter?.setProducts(viewModel.bussinesObject.value?.products as ArrayList<Product>?)

            val promosRecyclerView: RecyclerView = binding.promosContainer
            promosRecyclerView.layoutManager = linearLayoutManager
            promosRecyclerView.setHasFixedSize(true)
            promosAdapter = PromosAdapter()
            promosRecyclerView.adapter = promosAdapter
            promosAdapter?.setPromos(viewModel.bussinesObject.value?.promos as ArrayList<Promo>?)
        }
        return binding.root
    }
}