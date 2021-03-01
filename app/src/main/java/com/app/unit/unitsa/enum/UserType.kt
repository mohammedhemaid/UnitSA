package com.app.unit.unitsa.enum

enum class UserType(val value: Int) {
//    ADMIN(1),
//    OWNER(2),
//    MANAGER(3),
    TENANT(4),
    WORKER(5);

    companion object {
        fun isUserAllowed(userType: Int?): Boolean {
            for (user in values()) {
                if (user.value == userType) {
                    return true
                }
            }
            return false
        }
    }
}