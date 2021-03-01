package com.app.unit.unitsa.utils

import androidx.viewbinding.BuildConfig

object Constants {

    const val SOMETHING_WENT_WRONG = "Something went wrong"

    const val TERMS_AND_CONDITIONS = "https://ocost.co/termsandconditions"
    const val PRIVACY_POLICY = "https://ocost.co/privacypolicy"

    const val CATEGORY_TYPE = 0
    const val PRODUCT_TYPE = 1

    const val CASH_PAYMENT = 0
    const val ONLINE_PAYMENT = 1

    const val ORDER_ID = "orderId"

    const val MAIN_SUPPLIER_OC = "OC"

    val STAGING_MESSAGES_CHAT = if (BuildConfig.DEBUG) "stagingMessagesChat" else "messagesChat"
    val STAGING_MESSAGES_GROUP = if (BuildConfig.DEBUG) "stagingMessagesGroup" else "messagesGroup"
    const val MESSAGES = "messages"
    const val ORDERS = "orders"
    const val ORDER = "order"
    const val SUPPLIERS_ORDERS = "suppliersOrders"
    const val OC_ORDERS = "ocOrders"

    const val AR = "ar"
}