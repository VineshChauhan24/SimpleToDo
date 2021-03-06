package apps.jizzu.simpletodo.ui.view.settings.activity

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MenuItem
import android.view.WindowManager
import apps.jizzu.simpletodo.R
import apps.jizzu.simpletodo.service.widget.WidgetProvider
import apps.jizzu.simpletodo.ui.view.base.BaseActivity
import apps.jizzu.simpletodo.ui.view.settings.fragment.FragmentSettings
import kotlinx.android.synthetic.main.toolbar.*

class SettingsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        initToolbar(getString(R.string.settings), R.drawable.round_arrow_back_black_24)
        openSettingsFragment()
    }

    fun setToolbarTitle(title: String) {
        toolbarTitle.text = title
        checkScreenResolution()
    }

    private fun checkScreenResolution() {
        val displayMetrics = DisplayMetrics()
        (this.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels

        if (width <= 480 || height <= 800) {
            toolbarTitle.textSize = 18F
        }
    }

    private fun openSettingsFragment() =
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FragmentSettings()).commit()

    override fun onResume() {
        super.onResume()
        setToolbarTitle(getString(R.string.settings))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return false
    }

    override fun onPause() {
        super.onPause()

        val intent = Intent(this, WidgetProvider::class.java)
        intent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
        val ids = AppWidgetManager.getInstance(this@SettingsActivity)
                .getAppWidgetIds(ComponentName(this@SettingsActivity, WidgetProvider::class.java))
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids)
        sendBroadcast(intent)
    }
}
