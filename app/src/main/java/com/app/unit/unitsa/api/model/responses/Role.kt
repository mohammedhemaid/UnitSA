package com.app.unit.unitsa.api.model.responses


import com.google.gson.annotations.SerializedName

data class Role(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)