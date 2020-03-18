package com.dsw.bag.dswbag.repository
import  com.dsw.bag.dswbag.model.BussinesObject

import java.io.File
interface Repository {

    suspend fun getBagInfo(cashDir: File): BussinesObject
}