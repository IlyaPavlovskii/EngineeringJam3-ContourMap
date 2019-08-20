package by.bulba.contour.map.common.language

import android.content.SharedPreferences
import java.util.*

private const val LOCALE_ISO_KEY = "locale_iso"
private const val DEFAULT = "ru-RU"

class PreferencesLanguageRepository(
    private val sharedPreferences: SharedPreferences
) : LanguageRepository {

    override var locale: Locale
        get() {
            val iso = sharedPreferences.getString(LOCALE_ISO_KEY, DEFAULT)!!
            return Locale.forLanguageTag(iso)
        }
        set(value) {
            sharedPreferences.edit()
                .putString(LOCALE_ISO_KEY, value.displayLanguage)
                .apply()
        }

    companion object {
        lateinit var APP_INSTANCE: LanguageRepository
    }
}
