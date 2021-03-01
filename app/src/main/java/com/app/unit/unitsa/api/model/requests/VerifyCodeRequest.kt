package com.app.unit.unitsa.api.model.requests


import com.google.gson.annotations.SerializedName

data class VerifyCodeRequest(
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("verification_code")
    val verificationCode: String?
)