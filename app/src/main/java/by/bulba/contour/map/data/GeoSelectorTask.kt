package by.bulba.contour.map.data

import com.google.android.gms.maps.model.LatLng

data class GeoSelectorQuiz(
    val description: String,
    val minZoom: Float,
    val maxZoom: Float,
    val defaultZoom: Float,
    val centerPoint: LatLng?,
    val answers: List<GeoObject>,
    val correctAnswer: GeoObject
) : Task

data class GeoObject(
    val id: Int,
    val kmlLocalFilePath: String
)