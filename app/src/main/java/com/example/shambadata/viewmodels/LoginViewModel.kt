package com.example.shambadata.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shambadataapi.models.ShambaDataResponse
import com.example.shambadataapi.models.SigninResponse
import com.example.shambadataapi.models.requests.SigninRequest
import com.example.shambadataapi.repository.ShambaDataApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LoginViewModel(
    private val shambaDataApi: ShambaDataApi
) : ViewModel() {


    var loginState  = mutableStateOf(ShambaDataResponse<SigninResponse>())

     suspend fun loginRequest(
        username:String,
        password:String): ShambaDataResponse<SigninResponse> {
         loginState.value = shambaDataApi.signin(signinRequest = SigninRequest(username, password))
        return loginState.value
    }

}