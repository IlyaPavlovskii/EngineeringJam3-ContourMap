package by.bulba.contour.map.common.provider

import android.content.Context
import by.bulba.contour.map.data.GeoObject
import com.google.android.gms.maps.model.LatLng
import com.vividsolutions.jts.geom.Coordinate
import com.vividsolutions.jts.geom.GeometryFactory
import com.vividsolutions.jts.geom.Polygon
import java.io.FileNotFoundException
import java.io.Reader

private const val POLYGONES_PATTERN = "polygones/%s"

class FileGeoObjectPicker(
    val sourceFiles: Map<GeoObject, String>,
    val context: Context
) : GeoObjectPicker {

    private val factory = GeometryFactory()
    private val geometryMap = hashMapOf<GeoObject, Polygon>()
    var filterByObl = true

    fun init() {
        sourceFiles.iterator().forEach { entry ->
            val assetFilePath = POLYGONES_PATTERN.format(entry.value)
            context.assets.open(assetFilePath).bufferedReader().use {
                val geometry = parse(it)
                geometryMap[entry.key] = geometry
            }
        }
    }

    override fun getGeoObject(latLng: LatLng): GeoObject {
        val point = factory.createPoint(
            Coordinate(latLng.latitude, latLng.longitude)
        )
        geometryMap.iterator().forEach { entry ->
            if( filterByObl && entry.key.id > 999) {
                if (entry.value.contains(point)) {
                    return entry.key
                }
            }
            if( !filterByObl && entry.key.id < 999) {
                if (entry.value.contains(point)) {
                    return entry.key
                }
            }

        }
        throw FileNotFoundException("Geometry object not found exception")
    }

    private fun parse(reader: Reader): Polygon {
        val coordinates = arrayListOf<Coordinate>()
        reader.readText().split(" ").forEach { coordStr ->
            val coordStringArray = coordStr.split(",")
            coordinates.add(
                Coordinate(
                    coordStringArray[1].toDouble(),
                    coordStringArray[0].toDouble()
                )
            )
        }
        val array: Array<Coordinate> = coordinates.toTypedArray()
        return factory.createPolygon(array)!!

    }
}