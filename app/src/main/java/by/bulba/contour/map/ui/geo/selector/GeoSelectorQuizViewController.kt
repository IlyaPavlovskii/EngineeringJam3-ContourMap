package by.bulba.contour.map.ui.geo.selector

import android.app.Activity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import by.bulba.contour.map.common.geo.getApproximateCenter
import by.bulba.contour.map.common.provider.FileGeoObjectPicker
import by.bulba.contour.map.common.provider.GeoObjectPicker
import by.bulba.contour.map.common.view.KmlViewController
import by.bulba.contour.map.data.GeoObject
import by.bulba.contour.map.data.GeoSelectorQuiz
import by.bulba.contour.map.ui.geo.QuizActivity
import com.google.android.gms.maps.GoogleMap
import com.google.maps.android.data.kml.KmlLayer
import kotlin.math.max
import kotlin.math.min

class GeoSelectorQuizViewController(
    private val index: Int,
    private val limit: Int,
    private val activity: Activity,
    private val geoPicker: GeoObjectPicker,
    private val kmlViewController: KmlViewController
) {

    private var pickedPair: Pair<GeoObject, KmlLayer>? = null
    lateinit var task: GeoSelectorQuiz
    lateinit var acceptButton: Button
    lateinit var nextButton: Button
    lateinit var leftButton: ImageButton
    lateinit var rightButton: ImageButton

    fun initGoogleMap(googleMap: GoogleMap) {
        googleMap.setOnPolygonClickListener {
            if (nextButton.visibility == View.VISIBLE) {
                return@setOnPolygonClickListener
            }

            val center = it.getApproximateCenter()
            (geoPicker as FileGeoObjectPicker).filterByObl = task.correctAnswer.kmlLocalFilePath.contains("obl")
            pickedPair?.let { it.second.removeLayerFromMap() }
            val geoObject = geoPicker.getGeoObject(center)
            val layer = kmlViewController.addLayerFromAssets(
                geoObject.kmlLocalFilePath
                    .replace(".kml", "_selected.kml")
            )
            pickedPair = Pair(geoObject, layer)
        }
    }

    fun initListeners() {
        acceptButton.setOnClickListener {
            pickedPair?.let {
                acceptButton.visibility = View.GONE
                nextButton.visibility = View.VISIBLE
                it.second.removeLayerFromMap()
                if (task.correctAnswer.id == it.first.id) {
                    drawCorrectAnswer(it.first)
                } else {
                    drawCorrectAnswer(task.correctAnswer)
                    drawWrongAnswer(it.first)
                }
            }
        }
        nextButton.setOnClickListener {
            if (activity is QuizActivity) {
                activity.toQuestion(index + 1)
            }
        }
        rightButton.setOnClickListener {
            if (activity is QuizActivity) {
                activity.toQuestion(min(index + 1, limit))
            }
        }
        leftButton.setOnClickListener {
            if (activity is QuizActivity) {
                activity.toQuestion(max(index - 1, 0))
            }
        }
    }

    private fun drawCorrectAnswer(geoObject: GeoObject) {
        kmlViewController.addLayerFromAssets(
            geoObject.kmlLocalFilePath
                .replace(".kml", "_correct.kml")
        )
    }

    private fun drawWrongAnswer(geoObject: GeoObject) {
        kmlViewController.addLayerFromAssets(
            geoObject.kmlLocalFilePath
                .replace(".kml", "_wrong.kml")
        )
    }

}