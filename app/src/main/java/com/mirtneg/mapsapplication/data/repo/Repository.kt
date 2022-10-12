package com.mirtneg.mapsapplication.data.repo

import androidx.lifecycle.MutableLiveData
import com.mirtneg.rickandmorty.data.service.ApiService
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {
    val BASE_URL = "https://maps.googleapis.com/"
    val apiService: ApiService

    init {
        val client = OkHttpClient.Builder().build()
        apiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

}