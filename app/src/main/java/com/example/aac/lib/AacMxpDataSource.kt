package com.example.aac.lib

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AacMxpDataSource {

    fun createMxp(finish: FinishCallback<AacMxpHandle>) {

        GlobalScope.launch {
            delay(1000)
            finish.onFinish(AacMxpHandle(123))
        }

    }

}