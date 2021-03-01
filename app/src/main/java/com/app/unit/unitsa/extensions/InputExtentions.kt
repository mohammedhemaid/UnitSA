package com.app.unit.unitsa.extensions

import com.app.unit.unitsa.BuildConfig
import java.util.regex.Pattern

fun String.isValidMobile(): Boolean {
    return if (!BuildConfig.DEBUG){
        Pattern.compile("\\d{1,14}").matcher(this).matches()
    }else{
        Pattern.compile("\\d{9}").matcher(this).matches() || this == "1010"
    }
}
