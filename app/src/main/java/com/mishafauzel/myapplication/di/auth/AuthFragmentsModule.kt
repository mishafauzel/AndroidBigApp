package com.mishafauzel.myapplication.di.auth

import com.mishafauzel.myapplication.ui.auth.ForgetPassFragment
import com.mishafauzel.myapplication.ui.auth.HelloFragment
import com.mishafauzel.myapplication.ui.auth.LoginFragment
import com.mishafauzel.myapplication.ui.auth.RegisterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class AuthFragmentsModule {

    @ContributesAndroidInjector()
    abstract fun contributeHelloFragment(): HelloFragment
    @ContributesAndroidInjector
    abstract fun contributeLoginFragment():LoginFragment
    @ContributesAndroidInjector
    abstract fun contributeRegisterFragment():RegisterFragment
    @ContributesAndroidInjector
    abstract fun contributeForgetPass():ForgetPassFragment


}