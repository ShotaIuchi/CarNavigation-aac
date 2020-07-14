package com.example.aac.lib

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchDataSource {


    class Searcher {

        class cb {
            fun closefix() {
                Log.d("YYYYY", "closefix")
            }
            fun searchfix(i:Int) {
                Log.d("YYYYY", "searchfix$i")
            }
        }

        val c = cb()

        fun close() {
            GlobalScope.launch {
                delay(10)
                c.closefix()
            }
        }
        fun search() {
            GlobalScope.launch {
                delay(100)
                c.searchfix(1)
                delay(100)
                c.searchfix(2)
                delay(100)
                c.searchfix(3)
                delay(100)
                c.searchfix(4)
                delay(100)
                c.searchfix(5)
                delay(100)
                c.searchfix(6)
                delay(100)
                c.searchfix(7)
            }
        }
    }

    var searcher: Searcher? = null

    fun serch() {
        searcher?.let {
            it.close()
        }

        searcher = Searcher()
        searcher?.let {
            it.search()
        }
    }

}