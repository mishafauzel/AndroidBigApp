package com.mishafauzel.myapplication.util

class DataState<T>(
    val message:Event<String>?=null,
    val data:Event<T>?=null,
    var isLoading:Boolean=false

) {
    companion object{
        fun<T> success(data:T?,message:String?=null):DataState<T>
        {
            return DataState(message = Event.createMessageEvent(message),data = Event.createDataEvent(data))
        }
        fun<T> loading():DataState<T>
        {
            return DataState(isLoading = true)
        }
        fun<T> error(message:String):DataState<T>
        {
            return DataState(message = Event.createMessageEvent(message))
        }
    }
}