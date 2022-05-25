package com.example.shambadataapi.api

import android.util.Log
import com.example.shambadataapi.models.ShambaDataResponse
import kotlinx.coroutines.*
import retrofit2.Response
import java.io.IOException

private val TAG: String = "RequestMaker"
suspend fun <T> shambaDataApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> Response<T>
): ShambaDataResponse<T> {
    return withContext(dispatcher) {
        try {
            val responseDeffered: Deferred<Response<T>> = async { apiCall.invoke() }
            val response = responseDeffered.await()
            Log.d(TAG, "response: ${response.raw()}")
            if (response.isSuccessful) {
                Log.d(TAG, "success")
                ShambaDataResponse(
                    data = response.body(),
                    message = "successful",
                    isOk = true,
                    httpStatus = response.code()
                )
            } else {
                Log.e(TAG, "error: ${response}")
                ShambaDataResponse(
                    data = response.body(),
                    message = response.errorBody().toString(),
                    isOk = false,
                    httpStatus = response.code()
                )
            }

        } catch (error: IOException) {

            ShambaDataResponse(message = error.localizedMessage)
        }
    }
}