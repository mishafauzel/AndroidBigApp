package com.mishafauzel.myapplication.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import com.mishafauzel.myapplication.R
import com.mishafauzel.myapplication.api.auth.resposec.LoginResponse
import com.mishafauzel.myapplication.ui.BaseFragment
import com.mishafauzel.myapplication.util.ApiEmptyResponse
import com.mishafauzel.myapplication.util.ApiErrorResponse
import com.mishafauzel.myapplication.util.ApiSuccessResponse
import kotlinx.android.synthetic.main.fragment_login.*

private const val TAG = "LoginFragment"
class LoginFragment : BaseFragment(){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ${authViewModel==null},${authViewModel}")
        login_button.setOnClickListener()
        {
            authViewModel.testRepository().observe(viewLifecycleOwner){
                when(it)
                {
                    is ApiSuccessResponse<LoginResponse>-> Log.d(TAG, "onViewCreated: ${it.body}")
                    is ApiEmptyResponse-> Log.d(TAG, "onViewCreated: is empty")
                    is ApiErrorResponse-> Log.d(TAG, "onViewCreated: ${it.errorMessage}")
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


}