package com.mishafauzel.myapplication.api.auth

import androidx.lifecycle.LiveData
import com.mishafauzel.myapplication.api.auth.resposec.LoginResponse
import com.mishafauzel.myapplication.api.auth.resposec.RegistrationResponse
import com.mishafauzel.myapplication.util.GenericApiResponse
import retrofit2.http.*

interface OpenApiAuthService {
    @POST("account/login")
    @FormUrlEncoded
    fun login(@Field("username")email:String, @Field("password")password:String):LiveData<GenericApiResponse<LoginResponse>>
    @POST()
    @FormUrlEncoded
    fun register(@Field("email")email:String, @Field("password")password:String,@Field("username")username:String,@Field("password2")confirmPass:String):
            LiveData<GenericApiResponse<RegistrationResponse>>
}