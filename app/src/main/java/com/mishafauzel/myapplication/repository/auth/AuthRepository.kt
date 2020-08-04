package com.mishafauzel.myapplication.repository.auth

import androidx.lifecycle.LiveData
import com.mishafauzel.myapplication.api.auth.OpenApiAuthService
import com.mishafauzel.myapplication.api.auth.resposec.LoginResponse
import com.mishafauzel.myapplication.persistence.AccountPropertiesDao
import com.mishafauzel.myapplication.persistence.AuthTokenDao
import com.mishafauzel.myapplication.seesion.SessionManager
import com.mishafauzel.myapplication.util.GenericApiResponse
import javax.inject.Inject

class AuthRepository @Inject
constructor(
    val authTokenDao: AuthTokenDao,
    val accountPropertiesDao: AccountPropertiesDao,
    val openApiAuthService: OpenApiAuthService,
    val sessionManager: SessionManager
) {
    fun testLogin():LiveData<GenericApiResponse<LoginResponse>>
    {
        return openApiAuthService.login("mishafauze10@gmail.com","Asparagus1")
    }
}