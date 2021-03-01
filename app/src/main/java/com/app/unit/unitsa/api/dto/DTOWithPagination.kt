package com.app.unit.unitsa.api.dto

import com.app.unit.unitsa.api.model.responses.Pagination
import com.google.gson.annotations.SerializedName

data class DTOWithPagination<T>(
    @SerializedName("data")
    val `data`: T? = null,
    @SerializedName("pagination")
    val pagination: Pagination?,
)