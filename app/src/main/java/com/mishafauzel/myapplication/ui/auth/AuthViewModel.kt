package com.mishafauzel.myapplication.ui.auth

import android.media.session.MediaSession
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mishafauzel.myapplication.api.auth.resposec.LoginResponse
import com.mishafauzel.myapplication.models.Token
import com.mishafauzel.myapplication.repository.auth.AuthRepository
import com.mishafauzel.myapplication.ui.BaseViewModel
import com.mishafauzel.myapplication.ui.DataState
import com.mishafauzel.myapplication.ui.auth.state.AuthStateEvent
import com.mishafauzel.myapplication.ui.auth.state.AuthViewState
import com.mishafauzel.myapplication.ui.auth.state.LoginFields
import com.mishafauzel.myapplication.ui.auth.state.RegistrationFields
import com.mishafauzel.myapplication.util.AbsentLiveData
import com.mishafauzel.myapplication.util.GenericApiResponse
import javax.inject.Inject

class AuthViewModel @Inject constructor(var repository: AuthRepository):BaseViewModel<AuthStateEvent,AuthViewState>() {


    fun testRepository(): LiveData<GenericApiResponse<LoginResponse>> {
        return repository.testLogin()
    }

    override fun handleStateEvent(stateEvent: AuthStateEvent): LiveData<DataState<AuthViewState>> {
        return when (stateEvent) {
            is AuthStateEvent.LoginAttemptEvent -> AbsentLiveData.create()
            is AuthStateEvent.RegisterAttemptEvent -> AbsentLiveData.create()
            is AuthStateEvent.CheckPreviousAuthEvent -> AbsentLiveData.create()
        }
    }

    override fun initNewViewState(): AuthViewState {
        return AuthViewState()
    }

    fun setRegistrationField(registrationFields: RegistrationFields) {
        val authViewState = getCurrentViewStateOrNew()
        if (authViewState.registrationFields == registrationFields) {
            return
        }
        authViewState.registrationFields = registrationFields
        _viewState.value = authViewState
    }

    fun setLoginState(loginFields: LoginFields)
    {
        val authViewState=getCurrentViewStateOrNew()
        if(authViewState.loginFields==loginFields)
        {
            return
        }
        authViewState.loginFields=loginFields
        _viewState.value=authViewState
    }
    fun setAuthToken(authToken: Token){
        val update = getCurrentViewStateOrNew()
        if(update.authToken == authToken){
            return
        }
        update.authToken = authToken
        _viewState.value = update
    }




}