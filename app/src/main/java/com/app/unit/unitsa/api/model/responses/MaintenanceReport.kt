package com.app.unit.unitsa.api.model.responses


import com.google.gson.annotations.SerializedName

data class MaintenanceReport(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("items")
    val items: List<Item>?,
    @SerializedName("maintenance_id")
    val maintenanceId: Int?,
    @SerializedName("status")
    val status: Any?,
    @SerializedName("time_from")
    val timeFrom: String?,
    @SerializedName("time_to")
    val timeTo: String?
)