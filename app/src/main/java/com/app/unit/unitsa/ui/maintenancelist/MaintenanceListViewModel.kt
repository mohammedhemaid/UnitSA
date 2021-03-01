package com.app.unit.unitsa.ui.maintenancelist

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.app.unit.unitsa.api.repositories.MaintenanceRepository
import com.app.unit.unitsa.base.BaseViewModel
import com.app.unit.unitsa.managers.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MaintenanceListViewModel @Inject constructor(
    private val maintenanceRepository: MaintenanceRepository,
    private val preferencesManager: PreferencesManager
) : BaseViewModel() {

    val maintenanceList = maintenanceRepository
        .getAllMaintenanceList(preferencesManager.token)
        .cachedIn(viewModelScope)
}