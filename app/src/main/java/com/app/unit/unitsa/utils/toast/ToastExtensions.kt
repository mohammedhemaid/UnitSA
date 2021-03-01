package com.app.onlycost.utils.toast

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showLongToast(resourceId: Int) = showLongToast(getString(resourceId))

fun Fragment.showLongToast(message: String?) {
    val toast = Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT)
    ToastManager.setToast(toast)
    toast.show()
}