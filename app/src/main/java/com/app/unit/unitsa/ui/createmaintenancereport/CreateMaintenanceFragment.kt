package com.app.unit.unitsa.ui.createmaintenancereport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.unit.unitsa.databinding.FragmentCreateMaintenanceBinding
import com.app.unit.unitsa.extensions.getTimeHourMinutes
import com.app.unit.unitsa.ui.dialogs.datetimedialog.TimeAdder

class CreateMaintenanceFragment : Fragment() {

    private var _binding: FragmentCreateMaintenanceBinding? = null
    private val binding: FragmentCreateMaintenanceBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateMaintenanceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onFromClickListener()
        onToClickListener()
    }

    private fun onFromClickListener() {
        binding.from.setOnClickListener {
            TimeAdder(childFragmentManager) { timeChosen ->
                binding.from.setText(timeChosen.getTimeHourMinutes())
            }.show(System.currentTimeMillis())
        }
    }

    private fun onToClickListener() {
        binding.to.setOnClickListener {
            TimeAdder(childFragmentManager) { timeChosen ->
                binding.to.setText(timeChosen.getTimeHourMinutes())
            }.show(System.currentTimeMillis())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}