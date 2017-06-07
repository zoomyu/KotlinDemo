package com.zoomyu.kotlindemo.data

import com.google.gson.Gson

/**
 * Created by yuwei on 17-6-7.
 */
public class ForecastRequest(val cityID: String) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
//        private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&" +
//                "units=metric&cnt=7"
        private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json" +
                "&units=metric&cnt=7&lang=zh_cn"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&id="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = java.net.URL(COMPLETE_URL + cityID).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}