package com.zoomyu.kotlindemo.domain.model

/**
 * Created by yuwei on 17-6-7.
 */

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>) {
    operator fun get(positiuon: Int): Forecast = dailyForecast[positiuon]
    fun size(): Int = dailyForecast.size
}

data class Forecast(val date: String, val description: String, val high: Int, val low: Int,
                    val	iconUrl: String)
