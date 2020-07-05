package com.example.aac.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class FragmentViewModel : ViewModel() {

    val toast = MutableLiveData(false)
    val dialog = MutableLiveData(false)

}
