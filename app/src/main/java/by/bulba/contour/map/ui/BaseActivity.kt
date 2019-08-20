package by.bulba.contour.map.ui

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import by.bulba.contour.map.common.language.LanguageRepository
import by.bulba.contour.map.common.language.PreferencesLanguageRepository
import java.util.*

abstract class BaseActivity : AppCompatActivity() {

    protected val localeRepository: LanguageRepository = PreferencesLanguageRepository.APP_INSTANCE

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(applySelectedAppLanguage(base))
    }

    private fun applySelectedAppLanguage(context: Context): Context {
        val locale = localeRepository.locale
        val newConfig = Configuration(context.resources.configuration)
        Locale.setDefault(locale)
        newConfig.setLocale(locale)
        return context.createConfigurationContext(newConfig)
    }
}