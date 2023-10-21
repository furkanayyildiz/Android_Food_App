package com.example.foodorderapp.ui.viewModel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodorderapp.R
import com.example.foodorderapp.databinding.FragmentInfoBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class InfoFragment : Fragment(), OnMapReadyCallback {
    private lateinit var binding : FragmentInfoBinding
    private lateinit var mMap: GoogleMap
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        binding.buttonKonumaGit.setOnClickListener {
            // 41.0048519,28.6825318,10z

            val konum  = LatLng(41.0048519,28.6825318)
            mMap.addMarker(
                MarkerOptions().position(konum).title("Istanbul")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.info_icon)))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(konum,17f))
            mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onMapReady(p0: GoogleMap) {
        mMap = p0

        //39.9032599,32.5979551,11z
        val konum = LatLng(39.9032599,32.5979551)
        mMap.addMarker(MarkerOptions().position(konum).title("Ankara"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(konum))
    }

}