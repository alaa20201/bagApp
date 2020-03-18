package com.dsw.bag.dswbag.bagcashprovider

import com.dsw.bag.dswbag.model.BussinesObject
import com.epam.coroutinecache.annotations.*
import java.util.concurrent.TimeUnit

interface BagCash {
    /**
     * configure the cash and trigger an action to provide the bag object from the api
     *
     */
    @ProviderKey("BagCashe", EntryClass(BussinesObject::class))
    @LifeTime(value = 1L, unit = TimeUnit.MINUTES)
    @Expirable
    @UseIfExpired
    suspend fun getBag(bagProvider: suspend () -> BussinesObject): BussinesObject
}