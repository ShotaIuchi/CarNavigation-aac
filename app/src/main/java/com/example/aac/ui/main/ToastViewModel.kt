package com.example.aac.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToastViewModel : ViewModel() {

    data class Data(val message: String, val time: Long)

    public var data: SingleLiveEvent<Data>? = null
        get() {
            if (field == null) {
                field = SingleLiveEvent()
            }
            return field
        }
        private set

    fun show(data: Data) {
        this.data!!.postValue(data)
    }

    fun reset() {
        this.data = null
    }
}