package com.app.unit.unitsa.api.model.requests


import com.google.gson.annotations.SerializedName

data class CreateMaintenanceRequest(
    @SerializedName("items")
    val items: List<Item>?,
    @SerializedName("maintenance_id")
    val maintenanceId: Int?,
    @SerializedName("time_from")
    val timeFrom: String?,
    @SerializedName("time_to")
    val timeTo: String?
)