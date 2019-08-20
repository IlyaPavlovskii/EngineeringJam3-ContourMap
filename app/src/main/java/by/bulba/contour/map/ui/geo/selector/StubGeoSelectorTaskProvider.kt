package by.bulba.contour.map.ui.geo.selector

import by.bulba.contour.map.common.provider.TaskProvider
import by.bulba.contour.map.data.GeoObject
import by.bulba.contour.map.data.GeoSelectorQuiz
import com.google.android.gms.maps.model.LatLng

class StubGeoSelectorTaskProvider :
    TaskProvider<GeoSelectorQuiz> {

    private val answers = listOf(
        GeoObject(1, "by_brest.kml"),
        GeoObject(2, "by_vitebsk.kml"),
        GeoObject(3, "by_gomel.kml"),
        GeoObject(4, "by_grodno.kml"),
        GeoObject(5, "by_minsk.kml"),
        GeoObject(6, "by_mogilev.kml")
    )

    override val task: GeoSelectorQuiz = GeoSelectorQuiz(
        "Выберите Витебскую область",
        5.2f,
        6.5f,
        5.2f,
        LatLng(53.49036868765079, 27.64071609824896),
        answers,
        GeoObject(2, "by_vitebsk.kml")
    )
}