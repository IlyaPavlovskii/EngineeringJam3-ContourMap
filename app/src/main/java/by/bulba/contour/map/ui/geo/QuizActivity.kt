package by.bulba.contour.map.ui.geo

import android.os.Bundle
import by.bulba.contour.map.R
import by.bulba.contour.map.ui.BaseActivity
import by.bulba.contour.map.ui.geo.selector.GeoSelectorQuizFragment
import by.bulba.contour.map.ui.geo.selector.INDEX
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        quizBtnBack.setOnClickListener { finish() }

        startDefaultFragment()
    }

    fun toQuestion(index: Int) {
        val fragment = GeoSelectorQuizFragment()
        val bundle = Bundle()
        bundle.putInt(INDEX, index)
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.quizContainer,fragment)
            .commit()
    }

    private fun startDefaultFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.quizContainer, GeoSelectorQuizFragment())
            .commit()
    }
}