package com.mishafauzel.myapplication.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.mishafauzel.myapplication.viewmodels.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

private const val TAG = "BaseFragment"
abstract class BaseFragment:DaggerFragment() {
    @Inject
    lateinit var  viewModelFactory: ViewModelFactory
    lateinit var authViewModel: AuthViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authViewModel= ViewModelProvider(activity as FragmentActivity,viewModelFactory).get(AuthViewModel::class.java)

    }
}