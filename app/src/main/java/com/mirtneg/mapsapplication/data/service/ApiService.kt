package com.mirtneg.rickandmorty.data.service

import com.mirtneg.mapsapplication.data.models.PlacesResponse
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {

    @GET("/maps/api/place/nearbysearch/json")
    fun getPlaces(
        @Query("location") location: String,
        @Query("radius") radius: String = "2000",
        @Query("type") type: String
    ): Call<PlacesResponse>
}