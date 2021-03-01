package com.app.unit.unitsa.ui.maintenancelist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.unit.unitsa.R
import com.app.unit.unitsa.api.model.responses.Maintenance
import com.app.unit.unitsa.databinding.RowMaintenanceBinding

class MaintenanceListAdapter :
    PagingDataAdapter<Maintenance, MaintenanceListAdapter.ViewHolder>(COMPARATOR) {

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Maintenance>() {
            override fun areItemsTheSame(oldItem: Maintenance, newItem: Maintenance) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Maintenance, newItem: Maintenance) =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RowMaintenanceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    inner class ViewHolder(
        private val binding: RowMaintenanceBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bindView(maintenance: Maintenance?) {
            val tenant = maintenance?.tenant
            binding.apply {
                title.text = maintenance?.title
                tenantName.text = "${tenant?.firstName} ${tenant?.middleName} ${tenant?.lastName}"
                visitDate.text = "${maintenance?.visitDate} ${maintenance?.visitTime}"
                moreDetails.setOnClickListener {
                    it.findNavController().navigate(
                        MaintenanceListFragmentDirections.actionMaintenanceListFragmentToMaintenanceDetailsFragment()
                    )
                }
            }
        }
    }
}
/*    fun submitItems(deliveryNoteItems: MutableList<Maintenance>) {
        val diffResult =
            DiffUtil.calculateDiff(MaintenanceAdapterCallback(this.data, deliveryNoteItems))
        diffResult.dispatchUpdatesTo(this)
    }*/
