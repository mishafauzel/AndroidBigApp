package com.mishafauzel.myapplication.di

import androidx.lifecycle.ViewModelProvider

import com.mishafauzel.myapplication.viewmodels.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
 abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}