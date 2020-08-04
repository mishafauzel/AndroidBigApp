package com.mishafauzel.myapplication.seesion

import android.app.Application
import com.mishafauzel.myapplication.persistence.AuthTokenDao
import javax.inject.Inject

class SessionManager @Inject
constructor(
    val authTokenDao:AuthTokenDao,
    val application:Application
) {
}