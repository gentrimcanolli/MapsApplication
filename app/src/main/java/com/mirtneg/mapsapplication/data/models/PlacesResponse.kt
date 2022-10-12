package com.mirtneg.mapsapplication.data.models

import com.google.gson.annotations.SerializedName

data class PlacesResponse(
    @SerializedName("results") val results: List<Place>
)
