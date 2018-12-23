package apps.jizzu.simpletodo.service.widget

import android.content.Intent
import android.widget.RemoteViewsService
import apps.jizzu.simpletodo.service.widget.ViewFactory

/**
 * The service to be connected to for a remote adapter to request RemoteViews.
 */
class WidgetService : RemoteViewsService() {

    /**
     * Method to be implemented by the derived service to generate appropriate factories for the data.
     */
    override fun onGetViewFactory(intent: Intent) = ViewFactory(applicationContext)
}