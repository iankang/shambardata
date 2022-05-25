package com.example.shambadataapi.repository

import com.example.shambadataapi.api.ShambaDataRequests
import com.example.shambadataapi.api.shambaDataApiCall
import com.example.shambadataapi.models.ShambaDataResponse
import com.example.shambadataapi.models.SigninResponse
import com.example.shambadataapi.models.SignupResponse
import com.example.shambadataapi.models.UsernameAvailabilityResponse
import com.example.shambadataapi.models.requests.SignUpRequest
import com.example.shambadataapi.models.requests.SigninRequest
import org.koin.java.KoinJavaComponent.inject

class ShambaDataApi {
    private val shambaDataAPIRequests: ShambaDataRequests by inject(ShambaDataRequests::class.java)
    private val TAG = ShambaDataApi::class.java.name


    suspend fun signin(signinRequest: SigninRequest):ShambaDataResponse<SigninResponse> {
        return  shambaDataApiCall(apiCall = {shambaDataAPIRequests.signin(signinRequest)})
    }

    suspend fun signUp(signUpRequest: SignUpRequest):ShambaDataResponse<SignupResponse>{
        return shambaDataApiCall(apiCall = {shambaDataAPIRequests.signup(signUpRequest)})
    }

    suspend fun checkUserName(username:String): ShambaDataResponse<UsernameAvailabilityResponse>{
        return  shambaDataApiCall(apiCall = {shambaDataAPIRequests.checkUsername(username)})
    }

    suspend fun checkEmail(email:String):ShambaDataResponse<UsernameAvailabilityResponse>{
        return  shambaDataApiCall(apiCall = {shambaDataAPIRequests.checkEmail(email)})
    }
}