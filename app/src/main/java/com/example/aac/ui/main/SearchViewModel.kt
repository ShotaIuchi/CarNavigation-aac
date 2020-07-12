package com.example.aac.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aac.lib.PointInfo
import com.example.aac.lib.SearchRepository

class SearchViewModel : ViewModel() {

    private val searchRepository = SearchRepository()

    private var _pointInfo : MutableLiveData<ArrayList<PointInfo>> = MutableLiveData()
    val pointInfo : LiveData<ArrayList<PointInfo>>
        get() = _pointInfo

    fun search() {
        searchRepository.search(_pointInfo)
    }
}