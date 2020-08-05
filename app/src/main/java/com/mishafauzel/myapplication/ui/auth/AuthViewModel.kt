package com.mishafauzel.myapplication.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mishafauzel.myapplication.api.auth.resposec.LoginResponse
import com.mishafauzel.myapplication.repository.auth.AuthRepository
import com.mishafauzel.myapplication.util.GenericApiResponse
import javax.inject.Inject

class AuthViewModel @Inject constructor(var repository: AuthRepository):ViewModel() {

    fun testRepository():LiveData<GenericApiResponse<LoginResponse>>
    {
        return repository.testLogin()
    }





}