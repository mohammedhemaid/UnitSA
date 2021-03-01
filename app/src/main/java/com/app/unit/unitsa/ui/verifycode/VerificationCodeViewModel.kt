package com.app.unit.unitsa.ui.verifycode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.unit.unitsa.api.wrappers.Resource
import com.app.unit.unitsa.R
import com.app.unit.unitsa.api.ApiConstants
import com.app.unit.unitsa.api.model.requests.VerifyCodeRequest
import com.app.unit.unitsa.api.model.responses.VerifyCodeResponse
import com.app.unit.unitsa.api.repositories.AuthRepository
import com.app.unit.unitsa.base.BaseViewModel
import com.app.unit.unitsa.managers.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerificationCodeViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val preferencesManager: PreferencesManager
) : BaseViewModel() {

    private val _verificationCodeResponse = MutableLiveData<Any>()
    val verificationCodeResponse: LiveData<Any> get() = _verificationCodeResponse

    var verificationCode = ""

    fun verifyCode() {
        viewModelScope.launch {
            try {
                showProgressbar(true)
                handleVerificationCode(
                    authRepository.verifyCode(
                        VerifyCodeRequest(
                            phone = preferencesManager.phoneNumber,
                            verificationCode = verificationCode
                        )
                    )
                )
            } catch (e: Exception) {
                showProgressbar(false)
                showToastMessage(e.message ?: "")
                e.printStackTrace()
            }
        }
    }

    private fun handleVerificationCode(loginResponse: Resource<VerifyCodeResponse>) {
        when (loginResponse) {
            is Resource.Success -> loginResponse.data?.let {
                if (it.accessToken != null) {
                    preferencesManager.token ="${ApiConstants.BEARER} ${it.accessToken}"
                    _verificationCodeResponse.postValue(it)
                } else {
                    showToastMessage(R.string.error_in_login)
                }
            }
            is Resource.DataError -> {
                loginResponse.errorCode?.let {
                    showToastMessage(it)
                }
            }
        }
        showProgressbar(false)
    }
}