package com.example.aac.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToastViewModel : ViewModel() {

    public data class Data(val message: String, val time: Long)

    public var data: MutableLiveData<Data>? = null
        get() {
            if (field == null) {
                field = MutableLiveData()
            }
            return field
        }
        private set

    public fun show(data: Data) {
        this.data!!.postValue(data)
    }
}