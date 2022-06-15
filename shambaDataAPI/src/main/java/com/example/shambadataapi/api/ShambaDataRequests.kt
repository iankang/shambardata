package com.example.shambadataapi.api

import com.example.shambadataapi.models.FarmsResponse
import com.example.shambadataapi.models.SigninResponse
import com.example.shambadataapi.models.SignupResponse
import com.example.shambadataapi.models.UsernameAvailabilityResponse
import com.example.shambadataapi.models.requests.SignUpRequest
import com.example.shambadataapi.models.requests.SigninRequest
import retrofit2.Response
import retrofit2.http.*

interface ShambaDataRequests {

    @POST("/auth/signin")
    suspend fun signin(@Body signinRequest: SigninRequest): Response<SigninResponse>

    @POST("/auth/signup")
    suspend fun signup(@Body signUpRequest: SignUpRequest): Response<SignupResponse>

    @POST("/auth/check/username")
    suspend fun checkUsername(
        @Query("username") username: String
    ): Response<UsernameAvailabilityResponse>

    @POST("/auth/check/email")
    suspend fun checkEmail(
        @Query("email") email: String
    ): Response<UsernameAvailabilityResponse>

    @GET("/farm/{userId}/getFarms")
    suspend fun getFarms(
        @Path("userId") userId:Long
    ):Response<FarmsResponse>
}