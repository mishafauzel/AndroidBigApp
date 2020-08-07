package com.mishafauzel.myapplication.ui

import com.mishafauzel.myapplication.seesion.SessionManager
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

open class BaseActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var sessionManager:SessionManager

}