package com.mishafauzel.myapplication.di.auth

import androidx.lifecycle.ViewModel
import com.mishafauzel.myapplication.di.ViewModelKey
import com.mishafauzel.myapplication.ui.auth.AuthViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel

}