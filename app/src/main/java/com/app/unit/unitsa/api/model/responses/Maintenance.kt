package com.app.unit.unitsa.api.model.responses

import com.google.gson.annotations.SerializedName

data class Maintenance(
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("deleted_at")
    val deletedAt: Any?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("files")
    val files: Any?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("tenant")
    val tenant: Tenant?,
    @SerializedName("tenant_id")
    val tenantId: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("unit_id")
    val unitId: Int?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("visit_date")
    val visitDate: String?,
    @SerializedName("visit_time")
    val visitTime: String?,
    @SerializedName("worker_id")
    val workerId: Int?
)