package com.dsw.bag.dswbag.repository

import com.dsw.bag.dswbag.bagcashprovider.BagCash
import com.dsw.bag.dswbag.model.BussinesObject
import com.dsw.bag.dswbag.retrofit.BagRetrofitClient
import com.dsw.bag.dswbag.services.BagApiService
import com.epam.coroutinecache.api.CacheParams
import com.epam.coroutinecache.api.CoroutinesCache
import com.epam.coroutinecache.mappers.GsonMapper
import java.io.File

class RepositoryImpl: Repository {
    /**
           a method to retrieve the bag info
           @param cashDir which is the cash directory of the application
           if the data is saved in the cash then the data will be retrieved from the cash
           if not the data will be retrieved from the server
        */
    override suspend fun getBagInfo(cashDir: File): BussinesObject {
        val mCash = CoroutinesCache(CacheParams(10, GsonMapper(),cashDir))
        val mBagService = BagRetrofitClient.instance.create(BagApiService::class.java)
        val cacheProviders = mCash.using<BagCash>(BagCash::class.java)
        return mBagService::getBag?.let { cacheProviders.getBag(it) }
    }
}