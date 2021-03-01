package com.app.unit.unitsa.ui.verifycode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.app.unit.unitsa.base.BaseFragment
import com.app.unit.unitsa.base.BaseViewModel
import com.app.unit.unitsa.databinding.FragmentVerifyCodeBinding
import com.app.unit.unitsa.extensions.cleanText
import com.app.unit.unitsa.extensions.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VerifyCodeFragment : BaseFragment() {

    private val viewModel by viewModels<VerificationCodeViewModel>()

    private var _binding: FragmentVerifyCodeBinding? = null
    private val binding: FragmentVerifyCodeBinding get() = _binding!!

    override val baseViewModel: BaseViewModel get() = viewModel
    override val progressBar: ProgressBar get() = binding.progressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVerifyCodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onVerifyCodeClickListener()
        observe(viewModel.verificationCodeResponse, ::navigateToMaintenance)
    }

    private fun navigateToMaintenance(any: Any) {
        findNavController().navigate(
            VerifyCodeFragmentDirections.actionVerifyCodeFragmentToHomeNav()
        )
    }

    private fun onVerifyCodeClickListener() {
        binding.verify.setOnClickListener {
            viewModel.apply {
                verificationCode = binding.verificationCode.cleanText()
                verifyCode()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}