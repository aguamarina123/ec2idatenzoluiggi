package com.enzo.examenc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.enzo.examenc2.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMapsBinding
    private lateinit var googleMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentMap =
            supportFragmentManager.findFragmentById(R.id.mapas) as SupportMapFragment
        fragmentMap.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map

        val idatCentroLocation = LatLng(-12.101224, -77.035919)
        val idatSJLocation = LatLng(-11.9986873, -77.0210552)
        googleMap.addMarker(MarkerOptions().position(idatCentroLocation).title("Idat Centro"))
        googleMap.addMarker(
            MarkerOptions().position(idatCentroLocation).title("Idat San Juan De Lurigancho")
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(idatCentroLocation))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(idatSJLocation))
    }
}