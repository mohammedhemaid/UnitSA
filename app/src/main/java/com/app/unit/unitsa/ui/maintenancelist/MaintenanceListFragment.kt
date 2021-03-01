package com.app.unit.unitsa.ui.maintenancelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import com.app.unit.unitsa.R
import com.app.unit.unitsa.api.model.responses.Maintenance
import com.app.unit.unitsa.databinding.FragmentMaintenanceListBinding
import com.app.unit.unitsa.extensions.observe
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MaintenanceListFragment : Fragment() {

    private val viewModel by viewModels<MaintenanceListViewModel>()

    private var _binding: FragmentMaintenanceListBinding? = null
    private val binding: FragmentMaintenanceListBinding get() = _binding!!

    private lateinit var maintenanceListAdapter: MaintenanceListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMaintenanceListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        maintenanceListAdapter = MaintenanceListAdapter()
        binding.maintenanceList.adapter = maintenanceListAdapter

        observe(viewModel.maintenanceList, ::setMaintenanceList)
    }

    private fun initToolbar() {
        binding.toolbar.setToolbarImage(R.drawable.ic_unit_logo)
    }

    private fun setMaintenanceList(pagingData: PagingData<Maintenance>) {
        lifecycleScope.launch {
            maintenanceListAdapter.submitData(pagingData)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}