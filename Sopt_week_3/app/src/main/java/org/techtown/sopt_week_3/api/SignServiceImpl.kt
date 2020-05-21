package org.techtown.sopt_week_3.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SignServiceImpl {
    private const val BASE_URL = "http://13.209.144.115:3333"

    private val interceptor = object : Interceptor{
        override fun intercept(chain: Interceptor.Chain): Response {
            val newRequest = chain.request().newBuilder().addHeader("Content-Type","application/json")
                .build()

            return chain.proceed(newRequest)
        }
    }

    private val client = OkHttpClient.Builder().apply {
        interceptors().add(interceptor)
    }.build()

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val service = retrofit.create(SignService::class.java)

}