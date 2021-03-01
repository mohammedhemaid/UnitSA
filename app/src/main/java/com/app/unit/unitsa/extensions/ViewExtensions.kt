package com.app.unit.unitsa.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

fun ImageView.setIconTint(@ColorRes color: Int) {
    DrawableCompat.setTint(
        DrawableCompat.wrap(this.drawable),
        ContextCompat.getColor(this.context, color)
    )
}

fun View.hideKeyboard() {
    this.post {
        val windowToken = this.rootView?.windowToken
        windowToken?.let {
            val imm =
                this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it, 0)
        }
    }
}

fun EditText.cleanText(): String {
    return this.text.toString().trim()
}

fun EditText.isEmpty(): Boolean {
    return this.text.toString().trim().isEmpty()
}