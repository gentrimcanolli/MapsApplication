package com.mirtneg.mapsapplication.data.models

import com.google.gson.annotations.SerializedName

data class Geometry(
    @SerializedName("location") val location: Location
)
