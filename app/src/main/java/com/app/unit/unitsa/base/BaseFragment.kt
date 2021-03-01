package com.app.unit.unitsa.base

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.app.onlycost.utils.toast.showLongToast
import com.app.unit.unitsa.extensions.eventObserver
import com.app.unit.unitsa.extensions.observe

abstract class BaseFragment : Fragment() {

    abstract val baseViewModel: BaseViewModel
    abstract val progressBar: ProgressBar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(baseViewModel.progressBar, ::handelProgress)
        eventObserver(baseViewModel.showToast, ::showToastMessage)
        eventObserver(baseViewModel.showToastString, ::showToastMessage)
    }

    private fun handelProgress(show: Boolean) {
        progressBar.isVisible = show
    }

    private fun showToastMessage(message: String) {
        showLongToast(message)
    }

    private fun showToastMessage(message: Int) {
        showLongToast(message)
    }
}