package by.bulba.contour.map.common.geo

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.Polygon
import com.google.maps.android.PolyUtil
import com.google.maps.android.SphericalUtil

fun Polygon.getApproximateCenter(): LatLng {
    // Calc bounds first
    val boundsBuilder = LatLngBounds.builder()
    points.forEach {
        boundsBuilder.include(it)
    }
    val polygonBounds = boundsBuilder.build()

    val centerPoint = polygonBounds.center

    // Center point is inside the polygon, return it
    if (PolyUtil.containsLocation(centerPoint, points, true)) {
        return centerPoint
    }

    // Center point is out of bounds
    // Sample points at fixed percentages of the bounding box’s width East and West of the center point.
    val maxSearchSteps = 10
    var testPos: LatLng = centerPoint

    // Calculate NorthWest point so we can work out height of polygon NW->SE
    val northWest = LatLng(polygonBounds.northeast.latitude, polygonBounds.southwest.longitude)

    // Work out how tall and wide the bounds are and what our search
    // increment will be
    val boundsHeight = SphericalUtil.computeDistanceBetween(northWest, polygonBounds.southwest)
    val heightIncr = boundsHeight / maxSearchSteps

    val boundsWidth = SphericalUtil.computeDistanceBetween(northWest, polygonBounds.northeast)
    val widthIncr = boundsWidth / maxSearchSteps

    // Expand out from Centroid and find a point within polygon at
    // 0, 90, 180, 270 degrees
    for (n in 1..maxSearchSteps) {
        // Test point North of Centroid
        testPos = SphericalUtil.computeOffset(
            centerPoint,
            (heightIncr * n),
            0.0
        )
        if (PolyUtil.containsLocation(testPos, points, true)) {
            break
        }

        // Test point East of Centroid
        testPos = SphericalUtil.computeOffset(
            centerPoint,
            (widthIncr * n),
            90.0
        )
        if (PolyUtil.containsLocation(testPos, points, true)) {
            break
        }

        // Test point South of Centroid
        testPos = SphericalUtil.computeOffset(
            centerPoint,
            (heightIncr * n),
            180.0
        )
        if (PolyUtil.containsLocation(testPos, points, true)) {
            break
        }

        // Test point West of Centroid
        testPos = SphericalUtil.computeOffset(
            centerPoint,
            (widthIncr * n),
            270.0
        )
        if (PolyUtil.containsLocation(testPos, points, true)) {
            break
        }
    }

    return testPos
}