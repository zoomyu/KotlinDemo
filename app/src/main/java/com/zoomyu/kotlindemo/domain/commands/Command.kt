package com.zoomyu.kotlindemo.domain.commands

/**
 * Created by yuwei on 17-6-7.
 */
interface Command<out T> {
    fun execute(): T
}
