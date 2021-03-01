package com.app.unit.unitsa.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.app.unit.unitsa.utils.Event
import com.app.unit.unitsa.utils.EventObserver

fun <T> Fragment.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(viewLifecycleOwner, Observer { it?.let { t -> action(t) } })
}

fun <T> Fragment.eventObserver(liveData: LiveData<Event<T>>, action: (t: T) -> Unit) {
    liveData.observe(viewLifecycleOwner, EventObserver { it?.let { t -> action(t) } })
}