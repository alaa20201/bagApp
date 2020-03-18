package com.dsw.bag.dswbag.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dsw.bag.dswbag.R
import com.dsw.bag.dswbag.adapters.ProductsAdapter.ProductViewHolder
import com.dsw.bag.dswbag.databinding.ProductCellBinding
import com.dsw.bag.dswbag.model.Product
import java.text.FieldPosition
import java.util.*

class ProductsAdapter : RecyclerView.Adapter<ProductViewHolder>() {
    private var products: ArrayList<Product>? = null
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ProductViewHolder {
        val productCellBinding: ProductCellBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.context),
                R.layout.product_cell, viewGroup, false
            )
        return ProductViewHolder(productCellBinding)
    }

    override fun onBindViewHolder(
        productViewHolder: ProductViewHolder,
        position: Int
    ) {
        val product = products?.get(position)
        productViewHolder.productCellBinding.setProduct(product)
    }

    override fun getItemCount(): Int {
        return products?.size?:1
    }

    fun setProducts(products: ArrayList<Product>?) {
        this.products = products
        notifyDataSetChanged()
    }

    inner class ProductViewHolder(val productCellBinding: ProductCellBinding) :
        RecyclerView.ViewHolder(productCellBinding.root)
}