package com.mishafauzel.myapplication.util

class Event<T>(var data:T) {
    var isHandled:Boolean=false
    private set

    fun peekContent():T?
    {
        if(!isHandled) {
            isHandled=true
            return data
        }
        else
            return null
    }
    companion object
    {
        fun<T> createDataEvent(data:T?):Event<T>?
        {
            data?.let {
                return Event(it)
            }?:return null

        }
        fun createMessageEvent(messageString: String?):Event<String>?
        {
            messageString?.let{
                return Event(it)
            }?:return null
        }
    }
}