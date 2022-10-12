package com.mirtneg.mapsapplication.data.models

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("height") val height: Int,
    @SerializedName("width") val width: Int,
    @SerializedName("photo_reference") val photoReference: String,
)
