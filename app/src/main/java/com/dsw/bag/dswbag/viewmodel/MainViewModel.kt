package com.dsw.bag.dswbag.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsw.bag.dswbag.model.BussinesObject
import com.dsw.bag.dswbag.repository.Repository
import kotlinx.coroutines.launch
import java.io.File

class MainViewModel(val repository: Repository): ViewModel() {
    val ERROR_MSG = "error"
    var _bussinesObject: MutableLiveData<BussinesObject> = MutableLiveData()
    var bussinesObject: LiveData<BussinesObject> = _bussinesObject

    /**
     * this method will make a call and set the bag object in the viewmodel
     */
    fun bagInfo(cashDir: File){
        viewModelScope.launch{
            try {
                _bussinesObject.value = repository.getBagInfo(cashDir)

            }catch (e: retrofit2.HttpException){
                Log.e(ERROR_MSG, e.message)
        }

        }
    }
}