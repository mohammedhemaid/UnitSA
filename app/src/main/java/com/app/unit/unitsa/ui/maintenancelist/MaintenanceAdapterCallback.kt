package com.app.unit.unitsa.ui.maintenancelist

import androidx.recyclerview.widget.DiffUtil
import com.app.unit.unitsa.api.model.responses.Maintenance

class MaintenanceAdapterCallback internal constructor(
    private val oldList: List<Maintenance>,
    private val newList: List<Maintenance>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldTimeSchedule = oldList[oldItemPosition]
        val newTimeSchedule = newList[newItemPosition]
        return oldTimeSchedule == newTimeSchedule
    }
}