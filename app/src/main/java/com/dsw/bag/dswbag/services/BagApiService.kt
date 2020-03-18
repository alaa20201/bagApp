package com.dsw.bag.dswbag.services

import com.dsw.bag.dswbag.model.BussinesObject
import retrofit2.http.GET


interface BagApiService {
    @GET("/api/v1/bag")
    suspend fun getBag(): BussinesObject
}