package com.app.unit.unitsa.managers

import android.content.Context
import android.content.SharedPreferences

private const val PREFS_KEY = "com.app.onlycost"
private const val TOKEN = "token"
private const val PHONE_NUMBER = "phoneNumber"
private const val USER_ID = "userId"
private const val USER_TYPE = "userType"
private const val SELECTED_BRANCH_ID = "selectedBranchId"
private const val BRANCH_LIST = "branchList"
private const val USER_INFORMATION = "userInformation"
private const val ROLE_LIST = "roleList"
private const val IS_NEW = "isNew"
private const val IS_ACTIVE = "isActive"
private const val USER_PERMISSIONS = "userPermissions"
private const val ALL_PERMISSIONS = "allPermissions"

class PreferencesManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)

    var token: String
        get() = prefs.getString(TOKEN, "")!!
        set(value) {
            prefs.edit().putString(TOKEN, value).apply()
        }

    var phoneNumber: String
        get() = prefs.getString(PHONE_NUMBER, "")!!
        set(value) {
            prefs.edit().putString(PHONE_NUMBER, value).apply()
        }

    var userId: String
        get() = prefs.getString(USER_ID, "")!!
        set(value) {
            prefs.edit().putString(USER_ID, value).apply()
        }

    var userType: Int
        get() = prefs.getInt(USER_TYPE, -1)
        set(value) {
            prefs.edit().putInt(USER_TYPE, value).apply()
        }

    var selectedBranchId: Int
        get() = prefs.getInt(SELECTED_BRANCH_ID, -1)
        set(value) {
            prefs.edit().putInt(SELECTED_BRANCH_ID, value).commit()
        }

    var isNew: Boolean
        get() = prefs.getBoolean(IS_NEW, true)
        set(value) {
            prefs.edit().putBoolean(IS_NEW, value).apply()
        }

    var isActive: Boolean
        get() = prefs.getBoolean(IS_ACTIVE, false)
        set(value) {
            prefs.edit().putBoolean(IS_ACTIVE, value).apply()
        }

    var userPermissions: MutableSet<String>
        get() = prefs.getStringSet(USER_PERMISSIONS, mutableSetOf()) ?: mutableSetOf()
        set(value) {
            prefs.edit().putStringSet(USER_PERMISSIONS, value).commit()
        }

    fun clearLoginData() {
        val editor = prefs.edit()
        editor.clear()
        editor.commit()
    }
}