package org.test.hackernews.network

import android.util.Log
import retrofit2.HttpException


class ApiError constructor(error: Throwable) {
    var message = "An error occurred"
    init {
        if (error is HttpException) {
            val errorJsonString = error.response()?.errorBody()?.string()
            Log.e("Api error: ", errorJsonString.toString())
           /* this.message = Parser().parse(errorJsonString)
                .asJsonObject["message"]
                .asString*/
        } else {
            this.message = error.message ?: this.message
            Log.e("Api error: ", "No es httpException")

        }
    }
}