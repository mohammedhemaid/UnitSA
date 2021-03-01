package com.app.unit.unitsa.api.model.responses


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("maintenance_report_id")
    val maintenanceReportId: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("price")
    val price: String?,
    @SerializedName("quantity")
    val quantity: String?,
    @SerializedName("updated_at")
    val updatedAt: String?
)