package com.mirtneg.mapsapplication.data.models

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lng") val lon: Double
)
