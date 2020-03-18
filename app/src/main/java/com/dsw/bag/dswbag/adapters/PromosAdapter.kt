package com.dsw.bag.dswbag.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dsw.bag.dswbag.R
import com.dsw.bag.dswbag.adapters.ProductsAdapter.ProductViewHolder
import com.dsw.bag.dswbag.databinding.ProductCellBinding
import com.dsw.bag.dswbag.databinding.PromoCellBinding
import com.dsw.bag.dswbag.model.Product
import com.dsw.bag.dswbag.model.Promo
import java.text.FieldPosition
import java.util.*

class PromosAdapter : RecyclerView.Adapter<PromosAdapter.PromoViewHolder>() {
    private var promos: ArrayList<Promo>? = null
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PromoViewHolder {
        val promoCellBinding: PromoCellBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.context),
                R.layout.promo_cell, viewGroup, false
            )
        return PromoViewHolder(promoCellBinding)
    }

    override fun onBindViewHolder(
        promoViewHolder: PromoViewHolder,
        position: Int
    ) {
        val promo = promos?.get(position)
        promoViewHolder.promoCellBinding.setPromo(promo)
    }

    override fun getItemCount(): Int {
        return promos?.size?:1
    }

    fun setPromos(promos: ArrayList<Promo>?) {
        this.promos = promos
        notifyDataSetChanged()
    }

    inner class PromoViewHolder(val promoCellBinding: PromoCellBinding) :
        RecyclerView.ViewHolder(promoCellBinding.root)
}