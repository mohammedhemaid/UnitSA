package com.app.unit.unitsa.ui.dialogs.datetimedialog

import androidx.fragment.app.FragmentManager
import java.util.*

class TimeAdder(
    private val fragmentManager: FragmentManager,
    private val listener: (timeChosen: Long) -> Unit
) {

    private val calendar: Calendar = Calendar.getInstance()
    private var timePickerFragment: TimePickerFragment? = TimePickerFragment()
    private var selectedTime: Long = 0

    private val timeListener: TimePickerFragment.Listener = object : TimePickerFragment.Listener {
        override fun onTimeChosen(hourOfDay: Int, minute: Int) {
            timePickerFragment!!.setListener(null)
            calendar[Calendar.HOUR_OF_DAY] = hourOfDay
            calendar[Calendar.MINUTE] = minute
            listener.invoke(calendar.timeInMillis)
        }

        override fun getCurrentTime(): Long {
            return selectedTime
        }
    }

    fun show(currentTime: Long) {
        this.selectedTime = currentTime
        timePickerFragment!!.setListener(timeListener)
        timePickerFragment!!.show(fragmentManager, null)
    }

    fun cleanUp() {
        timePickerFragment = null
    }
}