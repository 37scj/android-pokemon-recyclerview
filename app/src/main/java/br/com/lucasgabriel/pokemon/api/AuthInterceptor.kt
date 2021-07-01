package br.com.lucasgabriel.pokemon.api

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {
        val requestBuilder = chain!!.request().newBuilder()
        //requestBuilder.addHeader("Authorization", "Basic cG9rZWFwaTpwb2tlbW9u")
        //requestBuilder.addHeader("client", "android")
        val request = requestBuilder.build()
        Log.d("MEUAPP", "HTTP Request: " + request.method() + " " + request.url().toString())
        val response = chain.proceed(request)
        if (response.code() == 401) {
            Log.e("MEUAPP", "Error API KEY")
        }
        return response
    }
}
