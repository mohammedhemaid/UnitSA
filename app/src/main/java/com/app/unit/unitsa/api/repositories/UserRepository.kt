package com.app.unit.unitsa.api.repositories

import com.app.unit.unitsa.api.services.UserService
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userService: UserService
) {

}