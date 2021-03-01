package com.app.unit.unitsa.api.model.responses


import com.google.gson.annotations.SerializedName

data class Tenant(
    @SerializedName("additional_phone")
    val additionalPhone: String?,
    @SerializedName("address")
    val address: String?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("company_name")
    val companyName: Any?,
    @SerializedName("copy_of_national_id")
    val copyOfNationalId: Any?,
    @SerializedName("copy_of_passport")
    val copyOfPassport: Any?,
    @SerializedName("copy_of_visa")
    val copyOfVisa: Any?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("deleted_at")
    val deletedAt: Any?,
    @SerializedName("documents")
    val documents: Any?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("is_company")
    val isCompany: String?,
    @SerializedName("last_name")
    val lastName: String?,
    @SerializedName("middle_name")
    val middleName: String?,
    @SerializedName("national_id")
    val nationalId: String?,
    @SerializedName("passport")
    val passport: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("tax_registration")
    val taxRegistration: String?,
    @SerializedName("trade_licence")
    val tradeLicence: Any?,
    @SerializedName("updated_at")
    val updatedAt: String?
)