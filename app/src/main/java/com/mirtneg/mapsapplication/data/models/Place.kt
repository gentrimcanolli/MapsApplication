package com.mirtneg.mapsapplication.data.models

import com.google.gson.annotations.SerializedName

data class Place(
    @SerializedName("business_status") val businessStatus: String,
    @SerializedName("geometry") val geometry: Geometry,
    @SerializedName("icon") val icon: String,
    @SerializedName("icon_background_color") val iconBackgroundColor: String,
    @SerializedName("icon_mask_base_uri") val iconMaskBaseUri: String,
    @SerializedName("name") val name: String,
    @SerializedName("opening_hours") val openingHours: OpeningHours,
    @SerializedName("photos") val photos: List<Photo>,
    @SerializedName("place_id") val placeId: String,
    @SerializedName("rating") val rating: Double,
    @SerializedName("reference") val reference: String,
    @SerializedName("scope") val scope: String,
    @SerializedName("types") val types: List<String>,
    @SerializedName("user_ratings_total") val userRatingsTotal: Int,
    @SerializedName("vicinity") val vicinity: String
)
