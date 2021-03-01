package com.app.unit.unitsa.api.repositories

import com.app.unit.unitsa.api.services.AuthService
import com.app.unit.unitsa.api.wrappers.ProcessCallResponse
import com.app.unit.unitsa.api.wrappers.Resource
import com.app.unit.unitsa.api.model.requests.LoginRequest
import com.app.unit.unitsa.api.model.requests.VerifyCodeRequest
import com.app.unit.unitsa.api.model.responses.LoginResponse
import com.app.unit.unitsa.api.model.responses.VerifyCodeResponse
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authService: AuthService) {

    suspend fun login(loginRequest: LoginRequest): Resource<LoginResponse> {
        return ProcessCallResponse<LoginResponse>().processCall(
            authService.login(loginRequest)
        )
    }

    suspend fun verifyCode(verifyCodeRequest: VerifyCodeRequest): Resource<VerifyCodeResponse> {
        return ProcessCallResponse<VerifyCodeResponse>().processCall(
            authService.verifyCode(verifyCodeRequest)
        )
    }
}