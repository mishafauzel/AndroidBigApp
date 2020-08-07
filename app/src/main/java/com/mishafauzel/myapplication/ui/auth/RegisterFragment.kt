package com.mishafauzel.myapplication.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import com.mishafauzel.myapplication.R
import com.mishafauzel.myapplication.ui.BaseFragment
import com.mishafauzel.myapplication.ui.auth.state.LoginFields
import com.mishafauzel.myapplication.ui.auth.state.RegistrationFields
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.input_email
import kotlinx.android.synthetic.main.fragment_login.input_password
import kotlinx.android.synthetic.main.fragment_register.*

private const val TAG = "RegisterFragment"
class RegisterFragment : BaseFragment(){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ${authViewModel==null},${authViewModel}")
        subscribeObservers()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if(!isStateSaved)
            saveState()
    }
    private fun subscribeObservers()
    {
        authViewModel.viewState.observe(this){
            Log.d(TAG, "subscribeObservers: observercalled")
            it.registrationFields?.let {
                it.registration_email?.let {
                    input_email.setText(it)
                }
                it.registration_username?.let{
                    input_username.setText(it)
                }
                it.registration_password?.let {
                    input_password.setText(it)
                }
                it.registration_confirm_password?.let{
                    input_password_confirm.setText(it)
                }
            }
        }
    }

    private fun saveState()
    {
        authViewModel.viewState.removeObservers(this)
        authViewModel.setRegistrationField( RegistrationFields(registration_email = input_email.text.toString(),registration_username = input_username.text.toString(),
            registration_password = input_password.text.toString(),registration_confirm_password = input_password_confirm.text.toString()))
    }


}