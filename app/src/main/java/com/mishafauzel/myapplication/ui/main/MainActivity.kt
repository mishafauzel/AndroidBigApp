package com.mishafauzel.myapplication.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mishafauzel.myapplication.R
import com.mishafauzel.myapplication.ui.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
}