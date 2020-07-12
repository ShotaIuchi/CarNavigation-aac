package com.example.aac.lib

data class PointInfo(
    val pointId: String,
    var name: String,
    var address: String,
    var gps: Gps
) {
    override fun toString(): String {
        return "id:$pointId | name:$name | address:$address | gps:$gps"
    }
}