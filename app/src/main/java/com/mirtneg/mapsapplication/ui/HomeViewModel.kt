package com.mirtneg.mapsapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mirtneg.mapsapplication.data.models.Place
import com.mirtneg.mapsapplication.data.models.PlacesResponse
import com.mirtneg.mapsapplication.data.repo.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    val repository = Repository()
    val places = MutableLiveData<List<Place>>()

    fun getPlaces() {
        repository.apiService.getPlaces("42.6629,21.1655", "2000", "restaurant", "AIzaSyDv6PAu7v3shh4i4ycKuW9TG6toCWyDzjI")
            .enqueue(object : Callback<PlacesResponse> {
                override fun onResponse(
                    call: Call<PlacesResponse>,
                    response: Response<PlacesResponse>) {
                    places.value = response.body()?.results
                }

                override fun onFailure(call: Call<PlacesResponse>, t: Throwable) {
                    t.printStackTrace()
                }

            })
    }
}