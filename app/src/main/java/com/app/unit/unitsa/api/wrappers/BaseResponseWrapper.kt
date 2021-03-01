package com.app.unit.unitsa.api.wrappers

import com.app.unit.unitsa.api.model.responses.Pagination
import com.google.gson.annotations.SerializedName

data class BaseResponseWrapper<T>(
    @SerializedName("data")
    val `data`: T? = null,
    @SerializedName( "message")
    val message: String,
    @SerializedName( "status")
    val status: Boolean?,
    @SerializedName( "pagination")
    val pagination: Pagination?,
)