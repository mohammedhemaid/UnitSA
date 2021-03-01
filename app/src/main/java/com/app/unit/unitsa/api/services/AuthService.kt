package com.app.unit.unitsa.api.services

import com.app.unit.unitsa.api.wrappers.GeneralResponse
import com.app.unit.unitsa.api.model.requests.LoginRequest
import com.app.unit.unitsa.api.model.requests.VerifyCodeRequest
import com.app.unit.unitsa.api.model.responses.LoginResponse
import com.app.unit.unitsa.api.model.responses.VerifyCodeResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): GeneralResponse<LoginResponse>

    @POST("auth/verifyCode")
    suspend fun verifyCode(
        @Body verifyCodeRequest: VerifyCodeRequest
    ): GeneralResponse<VerifyCodeResponse>
}