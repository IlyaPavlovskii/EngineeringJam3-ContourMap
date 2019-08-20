package by.bulba.contour.map

import android.app.Application
import android.content.Context
import by.bulba.contour.map.common.language.PreferencesLanguageRepository
import timber.log.Timber
import timber.log.Timber.DebugTree

private const val DEFAULT_SHARED_PREFERENCES = "default_shared_preferences"

/**
 * Application entry point.
 * */
class ContourMapApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupTimber()
        PreferencesLanguageRepository.APP_INSTANCE = PreferencesLanguageRepository(
            getSharedPreferences(DEFAULT_SHARED_PREFERENCES, Context.MODE_PRIVATE)
        )
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}