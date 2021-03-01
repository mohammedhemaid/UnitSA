package com.app.unit.unitsa.ui.maintenancedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.unit.unitsa.databinding.MaintenanceDetailsBinding

class MaintenanceDetailsFragment : Fragment() {

    private var _binding: MaintenanceDetailsBinding? = null
    private val binding: MaintenanceDetailsBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MaintenanceDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onAddReportClickListener()
    }

    private fun onAddReportClickListener() {
        binding.addReport.setOnClickListener {
            findNavController().navigate(
                MaintenanceDetailsFragmentDirections.actionMaintenanceDetailsFragmentToCreateMaintenanceFragment()
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}