package by.bulba.contour.map.ui.geo.selector

import android.content.Context
import android.location.Geocoder
import by.bulba.contour.map.common.provider.GeoObjectPicker
import by.bulba.contour.map.data.GeoObject
import com.google.android.gms.maps.model.LatLng
import timber.log.Timber
import java.lang.IllegalArgumentException

class OblGeoObjectPicker(
    context: Context
) : GeoObjectPicker {

    private val geocoder = Geocoder(context)

    override fun getGeoObject(latLng: LatLng): GeoObject {
        val address = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)[0]
        if(address.adminArea.contains("brest",true)) {
            return GeoObject(1, "by_brest_selected.kml")
        }
        if(address.adminArea.contains("vitebsk",true)) {
            return GeoObject(2, "by_vitebsk_selected.kml")
        }
        if(address.adminArea.contains("gomel",true)) {
            return GeoObject(3, "by_gomel_selected.kml")
        }
        if(address.adminArea.contains("rodn",true)) {
            return GeoObject(4, "by_grodno_selected.kml")
        }
        if(address.adminArea.contains("minsk",true)) {
            return GeoObject(5, "by_minsk_selected.kml")
        }
        if(address.adminArea.contains("mogilev",true)) {
            return GeoObject(6, "by_mogilev_selected.kml")
        }
        throw IllegalArgumentException("Unknown admin area: ${address.adminArea}")
    }

}