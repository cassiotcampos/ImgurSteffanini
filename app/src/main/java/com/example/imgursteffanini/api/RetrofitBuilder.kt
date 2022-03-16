package com.example.imgursteffanini.api

import com.example.imgursteffanini.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(interceptor())
            .build()
    }

    private fun interceptor(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return builder.build()
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}