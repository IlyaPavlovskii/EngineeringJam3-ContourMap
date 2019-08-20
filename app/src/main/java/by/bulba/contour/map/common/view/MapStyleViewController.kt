package by.bulba.contour.map.common.view

import android.content.Context
import androidx.annotation.RawRes
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.MapStyleOptions

class MapStyleViewController(
    private val context: Context,
    private val map: GoogleMap
) {

    fun loadMapStyle(@RawRes rawResId: Int) {
        val mapStyle = MapStyleOptions.loadRawResourceStyle(context, rawResId)
        map.setMapStyle(mapStyle)
    }

}