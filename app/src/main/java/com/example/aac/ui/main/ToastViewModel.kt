package com.example.aac.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToastViewModel : ViewModel() {

    enum class Show { NONE, CAN_SHOW, SHOWN }
    data class Data(val message: String, val time: Long)
    data class ISData(val isShow: Show, val data: Data)

    var data = MutableLiveData(ISData(Show.NONE, Data("",0)))

    /*
    public var data: SingleLiveEvent<Data>? = null
        get() {
            if (field == null) {
                field = SingleLiveEvent()
            }
            return field
        }
        private set
    */

    fun doShow(data: Data) {
        this.data.postValue(ISData(Show.CAN_SHOW, data))
    }

    fun showed() {
        this.data.value?.let {this.data.postValue(ISData(Show.SHOWN, it.data))}
    }

    fun reset() {
        this.data.postValue(ISData(Show.NONE, Data("", 0)))
    }
}