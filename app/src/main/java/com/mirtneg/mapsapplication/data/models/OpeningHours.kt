package com.mirtneg.mapsapplication.data.models

import com.google.gson.annotations.SerializedName

data class OpeningHours(
    @SerializedName("open_now") val openNow: Boolean

)
