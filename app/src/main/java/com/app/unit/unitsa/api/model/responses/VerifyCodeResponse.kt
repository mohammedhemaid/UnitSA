package com.app.unit.unitsa.api.model.responses

import com.google.gson.annotations.SerializedName

data class VerifyCodeResponse(
    @SerializedName("token")
    val accessToken: String?,
    @SerializedName("user")
    val user: User?
)