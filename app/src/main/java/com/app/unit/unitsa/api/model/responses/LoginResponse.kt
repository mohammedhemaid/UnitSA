package com.app.unit.unitsa.api.model.responses


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("user_role")
    val userRole: Int?
)