package com.mishafauzel.myapplication.ui.auth

import android.os.Bundle
import androidx.navigation.Navigation
import com.mishafauzel.myapplication.R
import dagger.android.support.DaggerAppCompatActivity

class AuthActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}