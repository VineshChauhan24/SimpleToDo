package apps.jizzu.simpletodo.ui.view.settings.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import apps.jizzu.simpletodo.R
import apps.jizzu.simpletodo.ui.view.settings.fragment.base.BaseSettingsFragment
import kotlinx.android.synthetic.main.fragment_licenses.*

class FragmentLicenses : BaseSettingsFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_licenses, container, false)
    }

    override fun onResume() {
        super.onResume()
        setTitle(getString(R.string.settings_page_title_licenses))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
    }

    private fun initButtons() {
        buttonKotterKnife.setOnClickListener { openUri(KOTTER_KNIFE_PAGE) }
        buttonCircularAnim.setOnClickListener { openUri(CIRCULAR_ANIM_PAGE) }
        buttonRxJava.setOnClickListener { openUri(RX_JAVA_PAGE) }
        buttonRxKotlin.setOnClickListener { openUri(RX_KOTLIN_PAGE) }
    }

    private fun openUri(uri: String) = startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)))

    private companion object {
        private const val KOTTER_KNIFE_PAGE = "https://github.com/JakeWharton/kotterknife"
        private const val CIRCULAR_ANIM_PAGE = "https://github.com/XunMengWinter/CircularAnim"
        private const val RX_JAVA_PAGE = "https://github.com/ReactiveX/RxJava"
        private const val RX_KOTLIN_PAGE = "https://github.com/ReactiveX/RxKotlin"
    }
}
