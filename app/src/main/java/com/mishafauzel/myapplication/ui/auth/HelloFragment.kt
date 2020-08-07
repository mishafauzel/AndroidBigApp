package com.mishafauzel.myapplication.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.mishafauzel.myapplication.R
import com.mishafauzel.myapplication.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_hello.*


class HelloFragment : BaseFragment() {

    private  val TAG = "HelloFragment"
    // TODO: Rename and change types of parameters
    private lateinit var navController: NavController



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hello, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ${authViewModel==null},${authViewModel}")
        navController=Navigation.findNavController(view)

       register.setOnClickListener{
            navigateRegister()
        }
        login.setOnClickListener{
            navigateLogin()
        }
        forgot_password.setOnClickListener{
            navigateForgetPass()
        }
//        authViewModel=ViewModelProvider(this,viewModelFactory).get(AuthViewModel::class.java)
//        Log.d(TAG, "onViewCreated: ${authViewModel==null}")

    }
    private fun navigateRegister()
    {
        navController.navigate(R.id.action_helloFragment_to_registerFragment)
    }
    private fun navigateLogin()
    {
        navController.navigate(R.id.action_helloFragment_to_loginFragment)
    }
    private fun navigateForgetPass()
    {
        navController.navigate(R.id.action_helloFragment_to_forgetPassFragment)
    }

}