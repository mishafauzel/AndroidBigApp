package com.mishafauzel.myapplication.di

import com.mishafauzel.myapplication.di.auth.AuthFragmentsModule
import com.mishafauzel.myapplication.di.auth.AuthModule
import com.mishafauzel.myapplication.di.auth.AuthViewModelModule
import com.mishafauzel.myapplication.di.auth.AuthScope
import com.mishafauzel.myapplication.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
        modules = [AuthModule::class, AuthFragmentsModule::class, AuthViewModelModule::class]
    )
    abstract fun contributeMainActivity(): AuthActivity
//you can add new activity

}