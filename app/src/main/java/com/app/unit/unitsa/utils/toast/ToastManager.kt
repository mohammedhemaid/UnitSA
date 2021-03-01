package com.app.onlycost.utils.toast

import android.widget.Toast

object ToastManager {

    private var sToast: Toast? = null

    @JvmStatic
    fun setToast(toast: Toast?) {
        if (sToast != null) sToast!!.cancel()
        sToast = toast
    }
}