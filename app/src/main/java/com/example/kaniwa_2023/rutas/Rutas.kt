package com.example.kaniwa_2023.rutas

import android.content.Context
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.kaniwa_2023.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Dash
import com.google.android.gms.maps.model.Dot
import com.google.android.gms.maps.model.Gap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.gms.maps.model.RoundCap

class Rutas (){
    companion object {
        fun ATAZ(map: GoogleMap, context: Context) {
            val polylineOptions = PolylineOptions()
                .add(LatLng(19.513159, -96.875301)).add(LatLng(19.514231, -96.876293))
                .add(LatLng(19.514867, -96.877655))
                .add(LatLng(19.515570, -96.879629)).add(LatLng(19.515919, -96.879994))
                .add(LatLng(19.517322, -96.880932))
                .add(LatLng(19.517664, -96.881358)).add(LatLng(19.518573, -96.882722))
                .add(LatLng(19.518917, -96.883012)).add(
                    LatLng(19.519913, -96.883790)
                )
                .add(LatLng(19.520247, -96.884289)).add(LatLng(19.522476, -96.894258))
                .add(LatLng(19.524312, -96.896621)).add(
                    LatLng(19.528484, -96.898686)
                )
                .add(LatLng(19.529091, -96.899457)).add(LatLng(19.532111, -96.905057))
                .add(LatLng(19.532222, -96.905119))
                .add(LatLng(19.533087, -96.906741)).add(LatLng(19.533237, -96.906911))
                .add(LatLng(19.533716606735606, -96.9073637145511))
                .add(LatLng(19.534072399005154, -96.90756353912303))
                .add(LatLng(19.53403700940078, -96.90770837840937)).add(
                    LatLng(19.533956118848486, -96.90787065205386)
                )
                .add(LatLng(19.533731937823557, -96.9081209466737))
                .add(LatLng(19.533730041948, -96.90819135466118))
                .add(LatLng(19.533790709950953, -96.90833753505167))
                .add(LatLng(19.54335988617218, -96.92675977189103))
                .add(LatLng(19.543374708864892, -96.92695983914527))
                .add(LatLng(19.54331404446314, -96.92705505756476))
                .add(LatLng(19.54325085235174, -96.92716368702924))
                .add(LatLng(19.54313584264787, -96.92738362816768))
                .add(LatLng(19.543035998993457, -96.92741447357118))
                .add(LatLng(19.541266154099898, -96.92631659622768))
                .add(LatLng(19.54111449106751, -96.92624819989771))
                .add(LatLng(19.540799789823655, -96.92617443914985))
                .add(LatLng(19.540632, -96.926203)).add(LatLng(19.540554, -96.926232))
                .add(LatLng(19.540479, -96.926229))
                .add(LatLng(19.540391, -96.926171)).add(LatLng(19.540391, -96.926171))
                .add(LatLng(19.540355, -96.925914))
                .add(LatLng(19.540400, -96.925841)).add(LatLng(19.540487, -96.925792))
                .add(LatLng(19.540661, -96.925827))
                .add(LatLng(19.540992613164047, -96.9260052770552))
                .add(LatLng(19.541288, -96.926215)).add(
                    LatLng(19.542585, -96.927003)
                )
                .add(LatLng(19.543212, -96.927058)).add(LatLng(19.543271, -96.926937))
                .add(LatLng(19.543270999176876, -96.92678947870952))
                .add(LatLng(19.543205, -96.926640)).add(LatLng(19.535418, -96.911594))
                .add(LatLng(19.534450, -96.912290))
                .add(LatLng(19.534371, -96.912155)).add(LatLng(19.535286, -96.911455))
                .add(LatLng(19.535459, -96.911346))
                .add(LatLng(19.535980, -96.911013)).add(LatLng(19.536605, -96.910506))
                .add(LatLng(19.537113, -96.910160))
                .add(LatLng(19.538359, -96.909300)).add(LatLng(19.539387, -96.908537))
                .add(LatLng(19.539914, -96.908198))
                .add(LatLng(19.539944538309033, -96.90811333102408))
                .add(LatLng(19.53991748428516, -96.9080080708572))
                .add(LatLng(19.539803, -96.907909)).add(LatLng(19.539652, -96.907894))
                .add(LatLng(19.539344, -96.907907))
                .add(LatLng(19.538808, -96.907899)).add(LatLng(19.538381, -96.907982))
                .add(LatLng(19.534387, -96.908157))
                .add(LatLng(19.534192, -96.908136)).add(LatLng(19.534033, -96.908105))
                .add(LatLng(19.533777, -96.908022))
                .add(LatLng(19.533700, -96.907972)).add(LatLng(19.533404, -96.907726))
                .add(LatLng(19.533331, -96.907633))
                .add(LatLng(19.533088, -96.907114)).add(LatLng(19.532961, -96.906939))
                .add(LatLng(19.532747396045167, -96.90659970076227))
                .add(LatLng(19.532747396045167, -96.90659970076227))
                .add(LatLng(19.531855, -96.904816))
                .add(LatLng(19.531855, -96.904816)).add(LatLng(19.528950, -96.899542))
                .add(LatLng(19.528605, -96.899062))
                .add(LatLng(19.528009, -96.898590)).add(LatLng(19.526616, -96.897870))
                .add(LatLng(19.526014, -96.897629))
                .add(LatLng(19.525529, -96.897366)).add(LatLng(19.524659, -96.896910))
                .add(LatLng(19.524310, -96.896722))
                .add(LatLng(19.524017, -96.896478)).add(LatLng(19.523301, -96.895624))
                .add(LatLng(19.522952, -96.895144))
                .add(LatLng(19.522434, -96.894495)).add(LatLng(19.522262, -96.894146))
                .add(LatLng(19.521407, -96.889561))
                .add(LatLng(19.520944, -96.887580)).add(LatLng(19.520017, -96.884168))
                .add(LatLng(19.519840, -96.883900))
                .add(LatLng(19.519418, -96.883506)).add(LatLng(19.519350, -96.883464))
                .add(LatLng(19.518607, -96.882941))
                .add(LatLng(19.518263, -96.882512)).add(LatLng(19.518035, -96.882206))
                .add(LatLng(19.517641, -96.881498))
                .add(LatLng(19.517338, -96.881157)).add(LatLng(19.516587, -96.880586))
                .add(LatLng(19.515839, -96.880087))
                .add(LatLng(19.515566, -96.879805)).add(LatLng(19.515407, -96.879523))
                .add(LatLng(19.514631, -96.877257))
                .add(LatLng(19.514444, -96.876881)).add(LatLng(19.514136, -96.876457))
                .add(LatLng(19.513752, -96.876186))
                .add(LatLng(19.513535, -96.876093)).add(LatLng(19.513115, -96.875728))
                .add(LatLng(19.512718, -96.875296))
                .add(LatLng(19.512522, -96.874968))

                //.add(LatLng())
                .width(15f)
                .color(ContextCompat.getColor(context, R.color.ATAZ))
            val polyline = map.addPolyline(polylineOptions)
            val pattern = listOf(
                Dot(), Gap(10f), Dash(50f), Gap(10f)
            )

            polyline.pattern = pattern
            polyline.startCap = RoundCap()
            polyline.endCap = RoundCap()
            //polyline.endCap = CustomCap(BitmapDescriptorFactory.fromResource(R.drawable.dcp1))
            polyline.isClickable = true
            map.setOnPolylineClickListener {
                Toast.makeText(
                    context,
                    "Ruta: ATAZ",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }
}