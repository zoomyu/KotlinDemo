package com.zoomyu.kotlindemo.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.zoomyu.kotlindemo.adapter.ForecastListAdapter
import com.zoomyu.kotlindemo.R
import com.zoomyu.kotlindemo.domain.commands.RequestForecastCommand
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val forecast_list = findViewById(R.id.forecast_list) as RecyclerView
        val forecast_list: RecyclerView = find(R.id.forecast_list)
        forecast_list.layoutManager = LinearLayoutManager(this)
        doAsync {
            val result = RequestForecastCommand("1796231").execute()
            uiThread {
                forecast_list.adapter = ForecastListAdapter(result)
            }
        }
    }

}
