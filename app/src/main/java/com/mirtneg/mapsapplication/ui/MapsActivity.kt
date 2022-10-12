package com.mirtneg.mapsapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.mirtneg.mapsapplication.R
import com.mirtneg.mapsapplication.data.models.Place
import com.mirtneg.mapsapplication.databinding.ActivityMapsBinding
import com.mirtneg.mapsapplication.ui.HomeViewModel.Companion.TYPE_HOTEL
import com.mirtneg.mapsapplication.ui.HomeViewModel.Companion.TYPE_RESTAURANT

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        setContentView(binding.root)


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.restaurants.setOnClickListener {
            viewModel.getPlaces(TYPE_HOTEL)
        }

        binding.hotels.setOnClickListener {
            viewModel.getPlaces(TYPE_RESTAURANT)
        }

        viewModel.places.observe(this) {
            showPlaces(it)
        }
    }

    private fun showPlaces(places: List<Place>) {
        mMap.clear()
        for (place in places) {
            mMap.addMarker(
                MarkerOptions()
                    .position(LatLng(place.geometry.location.lat, place.geometry.location.lon))
                    .title(place.name)
            )
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val pristina = LatLng(42.664, 21.1756)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pristina))
        mMap.animateCamera(CameraUpdateFactory.newLatLng(pristina))
        mMap.setMinZoomPreference(15f)
        viewModel.getPlaces(TYPE_RESTAURANT)

    }
}