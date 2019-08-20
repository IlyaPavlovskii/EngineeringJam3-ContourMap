package by.bulba.contour.map.ui.geo.selector

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.bulba.contour.map.R
import by.bulba.contour.map.common.factory.TaskProviderFactory
import by.bulba.contour.map.common.provider.StubTaskDescriptionProvider
import by.bulba.contour.map.common.provider.TaskDescriptionProvider
import by.bulba.contour.map.common.provider.TaskProvider
import by.bulba.contour.map.common.view.KmlViewController
import by.bulba.contour.map.common.view.MapStyleViewController
import by.bulba.contour.map.data.GeoSelectorQuiz
import by.bulba.contour.map.data.TaskDescription
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback
import kotlinx.android.synthetic.main.fragment_geo_selector_quiz.*

const val INDEX = "index"
private const val DEFAULT_INDEX = 0

class GeoSelectorQuizFragment : Fragment(), OnMapReadyCallback {

    private lateinit var taskDescriptionProvider: TaskDescriptionProvider<TaskDescription>
    private lateinit var taskProvider: TaskProvider<GeoSelectorQuiz>
    private lateinit var styleController: MapStyleViewController
    private lateinit var geoSelectorViewController: GeoSelectorQuizViewController
    private lateinit var kmlViewController: KmlViewController
    private var index: Int = DEFAULT_INDEX

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        index = arguments?.getInt(INDEX, DEFAULT_INDEX) ?: DEFAULT_INDEX
        taskProvider =
            TaskProviderFactory<TaskDescription, GeoSelectorQuiz>(taskDescriptionProvider).create(
                index
            )
        return LayoutInflater.from(context)
            .inflate(
                R.layout.fragment_geo_selector_quiz,
                container,
                false
            )
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        taskDescriptionProvider = StubTaskDescriptionProvider(context!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView.onCreate(savedInstanceState)
        mapView.onResume()
        try {
            MapsInitializer.initialize(activity!!.applicationContext)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        mapView.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        kmlViewController = KmlViewController(context!!, googleMap)

        val picker =
            StubGeoObjectPickerFactory.INSTANCE ?: StubGeoObjectPickerFactory(context!!).create()
        if (StubGeoObjectPickerFactory.INSTANCE == null) {
            StubGeoObjectPickerFactory.INSTANCE = picker
        }
        geoSelectorViewController = GeoSelectorQuizViewController(
            index,
            taskDescriptionProvider.taskDescriptions.size,
            requireActivity(),
            picker,
            kmlViewController
        )
        styleController = MapStyleViewController(context!!, googleMap)
        styleController.loadMapStyle(R.raw.style_json)

        googleMap.uiSettings.isCompassEnabled = false
        geoSelectorViewController.initGoogleMap(googleMap)

        setupTask(taskProvider.task, googleMap)
    }

    private fun setupTask(task: GeoSelectorQuiz, googleMap: GoogleMap) {
        if (task.minZoom > 0) {
            googleMap.setMinZoomPreference(task.minZoom)
        }
        if (task.maxZoom > 0) {
            googleMap.setMaxZoomPreference(task.maxZoom)
        }
        task.centerPoint?.let {
            googleMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(
                    it,
                    task.defaultZoom
                )
            )
        }
        task.answers.forEach { geoObject ->
            kmlViewController.addLayerFromAssets(geoObject.kmlLocalFilePath)
        }
        val pattern = context!!.getString(R.string.geo_selector_quiz_count_pattern)
        geoSelectorTvQuizCountTitle.text = pattern.format(
            index + 1,
            taskDescriptionProvider.taskDescriptions.size
        )
        geoSelectorTvQuestion.text = task.description
        geoSelectorViewController.task = task
        geoSelectorViewController.acceptButton = geoSelectorBtnAccept
        geoSelectorViewController.nextButton = geoSelectorBtnNext
        geoSelectorViewController.rightButton = geoSelectorBtnRight
        geoSelectorViewController.leftButton = geoSelectorBtnLeft
        geoSelectorViewController.initListeners()

    }
}