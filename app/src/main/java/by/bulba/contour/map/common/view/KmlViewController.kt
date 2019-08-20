package by.bulba.contour.map.common.view

import android.content.Context
import com.google.android.gms.maps.GoogleMap
import com.google.maps.android.data.kml.KmlLayer

private const val KML_ASSET_PATTERN = "kml/%s"

class KmlViewController(
    private val context: Context,
    private val map: GoogleMap
) {

    fun addLayerFromAssets(
        filePath: String
    ): KmlLayer {
        context.assets.open(KML_ASSET_PATTERN.format(filePath))
            .use { stream ->
                val layer = KmlLayer(map, stream, context)
                layer.addLayerToMap()
                return layer
            }
    }

}