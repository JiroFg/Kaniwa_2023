package com.example.kaniwa_2023

import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.kaniwa_2023.databinding.ActivityHomeBinding
import com.example.kaniwa_2023.menu_desplegable.CostFragment
import com.example.kaniwa_2023.menu_desplegable.HelpFragment
import com.example.kaniwa_2023.menu_desplegable.InfoFragment
import com.example.kaniwa_2023.menu_desplegable.MapFragment
import com.google.android.gms.common.api.Status
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.model.RectangularBounds
import com.google.android.libraries.places.api.net.PlacesClient
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var placesClient: PlacesClient
    private var mapFrag = MapFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = binding.homeActivityDrawer

        val toolbar = binding.toolBar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        val navigationView = binding.navView
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if(savedInstanceState === null){
            replaceFragment(mapFrag)
            navigationView.setCheckedItem(R.id.nav_home)
        }

        setupAutocomplete()

    }

    private fun setupAutocomplete(){
        if(!Places.isInitialized()){
            Places.initialize(this, "AIzaSyDd9w4RpuU7URzXqRE42sNKucKDNqNpYyA")
        }
        placesClient = Places.createClient(this)
        //Tomar el fragment del layout para referenciarlo
        val autocompleteFragment = supportFragmentManager.findFragmentById(R.id.autocomplete_fragment) as AutocompleteSupportFragment?
        autocompleteFragment!!.setPlaceFields(listOf(Place.Field.ID, Place.Field.ADDRESS, Place.Field.LAT_LNG))
        //instanciar rectangulo del area de Xalapa
        val xalapa = RectangularBounds.newInstance(
            LatLng(19.487500, -96.972906),
            LatLng(19.599870, -96.839109)
        )
        //Se setea el area restringida de busqueda y el pais
        autocompleteFragment.setLocationRestriction(xalapa)
        autocompleteFragment.setCountries("MX")

        //Listener al elegir elemento del fragment
        autocompleteFragment.setOnPlaceSelectedListener(object: PlaceSelectionListener{
            override fun onPlaceSelected(place: Place){
                buscarUbi(place.latLng!!)
                putMarkerOnMap(place.latLng!!, "Parada")
            }
            override fun onError(status: Status) {
                Log.e("ERROR","No se selecciono destino")
            }
        })
    }

    private fun putMarkerOnMap(latLng: LatLng, title: String){
        val markerView = (getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.marker_layout, null)
        val text = markerView.findViewById<TextView>(R.id.tv_bus)
        val cardView = markerView.findViewById<CardView>(R.id.cv_marker)

        text.text = title
        val bitmap = Bitmap.createScaledBitmap(viewToBitmap(cardView), cardView.width, cardView.height, false)
        val smallMarkerIcon = BitmapDescriptorFactory.fromBitmap(bitmap)
        mapFrag.addMarker(latLng, smallMarkerIcon)
    }

    private fun viewToBitmap(view: View): Bitmap{
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        val bitmap = Bitmap.createBitmap(view.measuredWidth, view.measuredHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        view.draw(canvas)
        return bitmap
    }

    private fun buscarUbi(latLng: LatLng){
        mapFrag.setZoom(latLng)
    }

    private fun replaceFragment(fragment: Fragment){
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.fragmentContainer.id, fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home -> replaceFragment(mapFrag)
            R.id.nav_cost -> replaceFragment(CostFragment())
            R.id.nav_help -> replaceFragment(HelpFragment())
            R.id.nav_info -> replaceFragment(InfoFragment())
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}