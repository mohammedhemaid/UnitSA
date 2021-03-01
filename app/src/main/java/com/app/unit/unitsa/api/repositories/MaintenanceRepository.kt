package com.app.unit.unitsa.api.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.app.unit.unitsa.api.dto.DTOWithPagination
import com.app.unit.unitsa.api.model.responses.Maintenance
import com.app.unit.unitsa.api.wrappers.Resource
import com.app.unit.unitsa.api.services.MaintenanceService
import com.app.unit.unitsa.api.wrappers.ProcessCallResponse
import com.app.unit.unitsa.ui.maintenancelist.MaintenanceDataSource
import javax.inject.Inject

class MaintenanceRepository @Inject constructor(private val maintenanceService: MaintenanceService) {

    fun getAllMaintenanceList(token: String) = Pager(
        config = PagingConfig(
            pageSize = 20,
            initialLoadSize = 40,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { MaintenanceDataSource(this, token) }
    ).liveData

    suspend fun getMaintenanceList(
        token: String,
        currentPage: Int,
        perPage: Int
    ): Resource<DTOWithPagination<List<Maintenance>?>> {
        return ProcessCallResponse<List<Maintenance>?>().processCall(
            maintenanceService.getMaintenanceList(token, currentPage, perPage)
        )
    }
}