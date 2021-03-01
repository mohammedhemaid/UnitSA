package com.app.unit.unitsa.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.unit.unitsa.api.wrappers.Resource
import com.app.unit.unitsa.R
import com.app.unit.unitsa.api.model.requests.LoginRequest
import com.app.unit.unitsa.api.model.responses.LoginResponse
import com.app.unit.unitsa.api.repositories.AuthRepository
import com.app.unit.unitsa.base.BaseViewModel
import com.app.unit.unitsa.enum.UserType
import com.app.unit.unitsa.extensions.isValidMobile
import com.app.unit.unitsa.managers.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val preferencesManager: PreferencesManager
) : BaseViewModel() {

    private val _loginResponse = MutableLiveData<Any>()
    val loginResponse: LiveData<Any> get() = _loginResponse

    var mobileNumber = ""

    fun signInWithPhoneNumber() {
        if (mobileNumber.isEmpty()) {
            showToastMessage(R.string.please_enter_mobile_number)
            showProgressbar(false)
            return
        }
        if (!mobileNumber.isValidMobile()) {
            showToastMessage(R.string.please_enter_a_valid_mobile_number)
            showProgressbar(false)
            return
        }
        viewModelScope.launch {
            try {
                showProgressbar(true)
                handleLogin(
                    authRepository.login(
                        LoginRequest(
                            phone = mobileNumber,
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

    private fun handleLogin(loginResponse: Resource<LoginResponse>) {
        when (loginResponse) {
            is Resource.Success -> loginResponse.data?.let {
                if (!UserType.isUserAllowed(it.userRole)) {
                    showToastMessage(R.string.user_not_allowed)
                    showProgressbar(false)
                    return
                }
                preferencesManager.phoneNumber = mobileNumber
                _loginResponse.postValue(it)
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