package com.example.aac.lib

import android.content.Context
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.databinding.BindingAdapter
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleOnSubscribe
import io.reactivex.rxjava3.observers.DisposableSingleObserver

@BindingAdapter("setAacMxpViewModel")
fun setAacMxpViewModel(view: AacMxpView, model: AacMxpViewModel) {
    view.setAacMxpViewModel(model)
}

class AacMxpView : SurfaceView, SurfaceHolder.Callback, SurfaceHolder.Callback2 {

    val aacMxpDataSource = AacMxpDataSource()

    var aacMapViewModel: AacMxpViewModel? = null

    constructor(context: Context?) : super(context) { initialize() }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) { initialize() }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) { initialize() }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) { initialize() }

    private fun initialize() {
        holder.addCallback(this)
    }

    fun setAacMxpViewModel(viewModel: AacMxpViewModel) {
        aacMapViewModel = viewModel
    }

    override fun surfaceRedrawNeeded(holder: SurfaceHolder?) {
        Single.create((SingleOnSubscribe<AacMxpHandle> {
            aacMxpDataSource.createMxp(object : FinishCallback<AacMxpHandle> {
                override fun onFinish(handle: AacMxpHandle) {
                    it.onSuccess(handle)
                }
            })
        })).subscribe(object : DisposableSingleObserver<AacMxpHandle>() {
            override fun onSuccess(t: AacMxpHandle?) {
                aacMapViewModel?.postMxpHandle(t)
            }
            override fun onError(e: Throwable?) {
            }
        })
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        aacMapViewModel?.postMxpHandle(null)
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
    }
}