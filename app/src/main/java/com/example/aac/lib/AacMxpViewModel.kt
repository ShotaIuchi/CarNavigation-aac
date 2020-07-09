package com.example.aac.lib

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AacMxpViewModel : ViewModel() {

    val _mxpHandle = MutableLiveData<AacMxpHandle>()
    public val mxpHandle: LiveData<AacMxpHandle>
        get() = _mxpHandle

//    val mxpHandle: MutableLiveData<AacMxpHandle> by lazy {
//        MutableLiveData<AacMxpHandle>()
//    }
//
    public fun postMxpHandle(handle: AacMxpHandle?) {
        _mxpHandle.postValue(handle)
    }

}