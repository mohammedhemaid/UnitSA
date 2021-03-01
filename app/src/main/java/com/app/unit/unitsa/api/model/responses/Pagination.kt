package com.app.unit.unitsa.api.model.responses

import com.google.gson.annotations.SerializedName

class Pagination(
    @SerializedName("current_page")
    val currentPage: Int?,
    @SerializedName("per_page")
    val perPage: String?,
    @SerializedName("total")
    val total: Int?
)