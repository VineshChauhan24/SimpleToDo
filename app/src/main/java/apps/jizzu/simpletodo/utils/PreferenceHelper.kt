package apps.jizzu.simpletodo.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper private constructor() {
    private lateinit var mPreferences: SharedPreferences

    fun init(context: Context) {
        mPreferences = context.getSharedPreferences("preferences", Context.MODE_PRIVATE)
    }

    fun putBoolean(key: String, value: Boolean) {
        val editor = mPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBoolean(key: String) = mPreferences.getBoolean(key, true)

    fun getInt(key: String) = mPreferences.getInt(key, 0)

    fun putInt(key: String, value: Int) {
        mPreferences.edit().apply {
            putInt(key, value)
            apply()
        }
    }

    companion object {
        const val ANIMATION_IS_ON = "animation_is_on"
        const val GENERAL_NOTIFICATION_IS_ON = "general_notification_is_on"
        const val VERSION_CODE = "version_code"
        const val IS_AFTER_DATABASE_MIGRATION = "is_after_database_migration"
        const val DATE_FORMAT_KEY = "date_format_key"
        const val TIME_FORMAT_KEY = "time_format_key"

        private var mInstance: PreferenceHelper? = null

        fun getInstance(): PreferenceHelper {
            if (mInstance == null) {
                mInstance = PreferenceHelper()
            }
            return mInstance as PreferenceHelper
        }
    }
}
