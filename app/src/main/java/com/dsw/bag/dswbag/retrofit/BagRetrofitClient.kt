package com.dsw.bag.dswbag.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object BagRetrofitClient {
    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://www.dsw.com"
    val instance: Retrofit
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
}