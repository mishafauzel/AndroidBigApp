package com.mishafauzel.myapplication.seesion

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mishafauzel.myapplication.models.Token
import com.mishafauzel.myapplication.persistence.AuthTokenDao
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject
constructor(
    val authTokenDao:AuthTokenDao,
    val application:Application
) {
    private val TAG = "SessionManager"
    private val _cachedToken=MutableLiveData<Token>()
    val cachedToken:LiveData<Token>
            get() = _cachedToken
    fun login(newValue:Token)
    {
        setValue(newValue)
    }
    fun logout(){
        GlobalScope.launch (IO){
            var errorMessage:String?=null
            try {
                cachedToken.value!!.account_pk?.let {
                    authTokenDao.nullifyToken(it)
                }
            }
            catch(exception:CancellationException)
            {
                Log.d(TAG, "login: ${exception.message}")
                errorMessage=exception.message
            }
            catch (e:Exception)
            {
                Log.d(TAG, "login: ${e.message}")
                errorMessage="$errorMessage ${e.message}\n"
            }
            finally {
                errorMessage?.let{
                    Log.d(TAG, "login: $errorMessage")
                    Log.d(TAG, "login:finally ")
                    setValue(null)
                }
            }

        }
    }

   fun setValue(newValue: Token?) {
       GlobalScope.launch (Main){
           if(_cachedToken.value!=newValue)
           _cachedToken.value=newValue
       }
    }

    fun isConnectedToTheInternet():Boolean
    {
        val cm=application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val nw      = cm.activeNetwork ?: return false
                val actNw = cm.getNetworkCapabilities(nw) ?: return false
                return when {
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    //for other device how are able to connect with Ethernet
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    //for check internet over Bluetooth
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
                    else -> false
                }
            } else {
                val nwInfo = cm.activeNetworkInfo ?: return false
                return nwInfo.isConnected
            }
        }catch (e:Exception)
        {
            Log.d(TAG, "isConnectedToTheInternet: isConnecte")
        }
        return false
    }

}