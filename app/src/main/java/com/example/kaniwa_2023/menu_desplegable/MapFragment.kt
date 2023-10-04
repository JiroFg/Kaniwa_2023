package com.example.kaniwa_2023.menu_desplegable

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.kaniwa_2023.R
import com.example.kaniwa_2023.databinding.FragmentMapBinding
import com.example.kaniwa_2023.rutas.Rutas
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(R.layout.fragment_map), OnMapReadyCallback {

    companion object {
        const val REQUEST_CODE_LOCATION = 0
    }

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!
    private lateinit var map:GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.onResume()
        binding.mapView.getMapAsync(this)
        return binding.root
    }

    override fun onMapReady(map: GoogleMap) {
        this.map = map
        enabledLocation()
        setCityLocation()
        Rutas.ATAZ(map,requireContext())
    }

    //Metodo para hacer zoom en una coordenada especifica
    fun setZoom(latLng: LatLng){
        map.clear()
        val coordenadas = latLng
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordenadas, 17f), 2000,null)
        val ubicacion = MarkerOptions().position(coordenadas).title("Ubicación buscada")
        map.addMarker(ubicacion)
    }

    private fun setCityLocation(){
        val xalapa = LatLng(19.542068, -96.926764)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(xalapa, 15f))
    }

    private fun isLocationPermissionGranted() = ContextCompat.checkSelfPermission(
        requireActivity(),
        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED

    private fun enabledLocation(){
        if(!::map.isInitialized) return
        if(isLocationPermissionGranted()){
            map.isMyLocationEnabled = true
        }else{
            requestLocationPermission()
        }
    }

    private fun requestLocationPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), Manifest.permission.ACCESS_FINE_LOCATION)){
            Toast.makeText(requireActivity(), "Se requiere permiso para mostrar su ubicación",Toast.LENGTH_SHORT).show()
        }else{
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE_LOCATION
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            REQUEST_CODE_LOCATION -> if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                map.isMyLocationEnabled = true
            }else{
                Toast.makeText(requireActivity(), "Se requiere permiso para mostrar su ubicación",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if(!::map.isInitialized) return
        if(!isLocationPermissionGranted()){
            map.isMyLocationEnabled = false
            Toast.makeText(requireActivity(), "Se requiere permiso para mostrar su ubicación",Toast.LENGTH_SHORT).show()
        }
    }

    fun addMarker(latLng: LatLng, icon: BitmapDescriptor){
        map.addMarker(MarkerOptions().position(latLng).icon(icon))
    }
}