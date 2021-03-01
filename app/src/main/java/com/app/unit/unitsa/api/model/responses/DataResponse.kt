package com.app.unit.unitsa.api.model.responses

import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("maintenances")
    val maintenanceList: List<Maintenance>?,
    @SerializedName("maintenances_reports")
    val maintenanceReports: List<MaintenanceReport>?,
)