package com.app.unit.unitsa.api.model.requests


import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("phone")
    val phone: String?
)