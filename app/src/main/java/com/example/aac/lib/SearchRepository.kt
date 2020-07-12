package com.example.aac.lib

import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchRepository() {

    fun search(result: MutableLiveData<ArrayList<PointInfo>>) {
        Observable.create(ObservableOnSubscribe<ArrayList<PointInfo>> {
            GlobalScope.launch {
                var index = 0
                for (i in 0..10) {
                    val t = ArrayList<PointInfo>()
                    for (j in 0..4) {
                        val p = "${i.toString()}|${j.toString()}"
                        t.add(PointInfo(index.toString(),p,p,Gps(i.toLong(),j.toLong())))
                        index++
                    }
                    it.onNext(t)
                    delay(1000)
                }
                it.onComplete()
            }
        }).subscribe(object: Observer<ArrayList<PointInfo>> {
            override fun onComplete() {
            }
            override fun onSubscribe(d: Disposable?) {
            }
            override fun onNext(t: ArrayList<PointInfo>) {
                val newValue = ArrayList<PointInfo>()
                result.value?.let {
                    newValue.addAll(it)
                }
                newValue.addAll(t)
                result.postValue(newValue)
            }
            override fun onError(e: Throwable?) {
            }

        })
    }
}