package com.dsw.bag.dswbag.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class Summery(
    val subtotal:String? = null,
    val tax: String? = null,
    val discounts: String? = null,
    val total: String? = null
):Parcelable
@Parcelize
data class Promo(
    val code: String? = null,
    val description: String? = null,
    val value: String? = null
):Parcelable
@Parcelize
data class Product(
    val sku: String? = null,
    val displayName: String? = null,
    val price: String? = null,
    val quantity: Int? = null
):Parcelable
@Parcelize
data class BussinesObject(
    val products: List<Product>? = null,
    val promos: List<Promo>? = null,
    val summery: Summery? = null
):Parcelable
