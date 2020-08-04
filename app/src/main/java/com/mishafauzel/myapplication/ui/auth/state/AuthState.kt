package com.mishafauzel.myapplication.ui.auth.state

sealed class AuthState {
    class LoginState(val email:String,val password:String):AuthState()
    class RegisterState(val email: String,val username:String,val password: String,var password2:String):AuthState()
    class RestorePasswordState:AuthState()
    class None:AuthState()
}