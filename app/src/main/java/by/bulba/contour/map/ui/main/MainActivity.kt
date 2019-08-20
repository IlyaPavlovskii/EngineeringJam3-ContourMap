package by.bulba.contour.map.ui.main

import android.content.Intent
import android.os.Bundle
import by.bulba.contour.map.R
import by.bulba.contour.map.ui.BaseActivity
import by.bulba.contour.map.ui.geo.QuizActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainBtnBy.setOnClickListener {
            if (!localeRepository.locale.toLanguageTag().contains("by")) {
                localeRepository.locale = Locale.forLanguageTag("by-BY")
                recreate()
            }
        }
        mainBtnRu.setOnClickListener {
            if (!localeRepository.locale.toLanguageTag().contains("ru")) {
                localeRepository.locale = Locale.forLanguageTag("ru-RU")
                recreate()
            }
        }
        mainBtnMapQuiz.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }
        updateButtonState()
    }

    private fun updateButtonState() {
        if (localeRepository.locale.toLanguageTag().contains("ru")) {
            mainBtnRu.setBackgroundResource(R.drawable.blue_button_selector)
            mainBtnRu.setTextColor(resources.getColor(R.color.white))
            mainBtnBy.setBackgroundResource(R.drawable.gray_button_selector)
            mainBtnBy.setTextColor(resources.getColor(R.color.gray))
        } else {
            mainBtnBy.setBackgroundResource(R.drawable.blue_button_selector)
            mainBtnBy.setTextColor(resources.getColor(R.color.white))
            mainBtnRu.setBackgroundResource(R.drawable.gray_button_selector)
            mainBtnRu.setTextColor(resources.getColor(R.color.gray))
        }
    }

}
