package com.mishafauzel.myapplication.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.switchMap
import androidx.lifecycle.ViewModel
import com.mishafauzel.myapplication.api.auth.resposec.LoginResponse
import com.mishafauzel.myapplication.repository.auth.AuthRepository
import com.mishafauzel.myapplication.ui.auth.state.AuthState
import com.mishafauzel.myapplication.ui.auth.state.AuthViewState
import com.mishafauzel.myapplication.util.DataState
import com.mishafauzel.myapplication.util.GenericApiResponse
import javax.inject.Inject

class AuthViewModel @Inject constructor(var repository: AuthRepository):ViewModel() {

    fun testRepository():LiveData<GenericApiResponse<LoginResponse>>
    {
        return repository.testLogin()
    }

//    private val _stateEvent=MutableLiveData<AuthState>()
//    private val _viewState=MutableLiveData<AuthViewState>()
//    val dataState:LiveData<DataState<AuthViewState>> = switchMap(_stateEvent)
//
//    {
//        handleStateEvent(it)
//    }
//    val viewState:LiveData<AuthViewState>
//        get()=viewState
//    private fun handleStateEvent(stateEvent:AuthState):LiveData<DataState<AuthViewState>>
//    {
//        return when(stateEvent)
//        {
//            is AuthState.LoginState-> login(stateEvent)
//
//            is AuthState.RegisterState -> register(stateEvent)
//            is AuthState.RestorePasswordState -> restorePassword(stateEvent)
//            is AuthState.None -> TODO()
//        }
//    }
//
//    private fun register(stateEvent: AuthState.RegisterState):LiveData<DataState<AuthViewState>>
//    {
//
//    }
//    private fun login(stateEvent: AuthState.LoginState):LiveData<DataState<AuthViewState>>
//    {
//
//    }
//    private fun restorePassword(stateEvent: AuthState.RestorePasswordState):LiveData<DataState<AuthViewState>>
//    {
//
//    }



}