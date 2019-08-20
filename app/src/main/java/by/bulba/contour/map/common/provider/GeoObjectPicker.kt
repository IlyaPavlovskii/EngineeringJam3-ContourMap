package by.bulba.contour.map.common.provider

import by.bulba.contour.map.data.GeoObject
import com.google.android.gms.maps.model.LatLng

interface GeoObjectPicker {

    fun getGeoObject(latLng: LatLng): GeoObject

}