package com.app.unit.unitsa.api.services

import com.app.unit.unitsa.api.wrappers.GeneralResponse
import com.app.unit.unitsa.api.ApiConstants
import com.app.unit.unitsa.api.model.responses.DataResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MaintenanceService {

    @GET("worker/maintenances")
    suspend fun getMaintenanceList(
        @Header(ApiConstants.AUTHORIZATION) token: String,
        @Query("current_page") currentPage: Int,
        @Query("per_page") perPage: Int
    ): GeneralResponse<DataResponse>
}