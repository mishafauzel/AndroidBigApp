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
import com.mishafauzel.myapplication.ui.auth.state.LoginFields
import com.mishafauzel.myapplication.util.ApiEmptyResponse
import com.mishafauzel.myapplication.util.ApiErrorResponse
import com.mishafauzel.myapplication.util.ApiSuccessResponse
import kotlinx.android.synthetic.main.fragment_login.*

private const val TAG = "LoginFragment"
class LoginFragment : BaseFragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

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
        subscribeObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: ${input_email==null},${isStateSaved}")
        if(!isStateSaved)
            saveState()
    }







    private fun subscribeObservers()
    {
        authViewModel.viewState.observe(this){
            it.loginFields?.let {
                it.login_email?.let {
                    input_email.setText(it)
                }
                it.login_password?.let{
                    input_password.setText(it)
                }
            }
        }
    }

    private fun saveState()
    {
        authViewModel.viewState.removeObservers(this)
        authViewModel.setLoginState( LoginFields(login_email = input_email.text.toString(),login_password = input_password.text.toString()))
    }




}