package com.app.unit.unitsa.extensions

import java.text.SimpleDateFormat
import java.util.*

private const val TIME_STAMP_FORMAT = "dd/MM/yyyy - hh:mm a"
private const val HH_MM = "hh:mm a"

fun Long.getDateTime(): String {
    val date = Date(this)
    val simpleDateFormat = SimpleDateFormat(TIME_STAMP_FORMAT, Locale.ENGLISH)
    simpleDateFormat.timeZone = TimeZone.getDefault()
    return simpleDateFormat.format(date)
}

fun Long.getTimeHourMinutes(timeZone: TimeZone = TimeZone.getDefault()): String {
    val date = Date(this)
    val simpleDateFormat = SimpleDateFormat(HH_MM, Locale.getDefault())
    simpleDateFormat.timeZone = timeZone
    return simpleDateFormat.format(date)
}
