package com.zoomyu.kotlindemo.domain.commands

import com.zoomyu.kotlindemo.data.ForecastRequest
import com.zoomyu.kotlindemo.domain.mappers.ForecastDataMapper
import com.zoomyu.kotlindemo.domain.model.ForecastList

/**
 * Created by yuwei on 17-6-7.
 */

class RequestForecastCommand(val cityID: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(cityID)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}