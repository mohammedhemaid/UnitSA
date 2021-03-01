package com.app.unit.unitsa.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.app.unit.unitsa.base.BaseFragment
import com.app.unit.unitsa.base.BaseViewModel
import com.app.unit.unitsa.databinding.FragmentLoginBinding
import com.app.unit.unitsa.extensions.cleanText
import com.app.unit.unitsa.extensions.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override val baseViewModel: BaseViewModel get() = viewModel
    override val progressBar: ProgressBar get() = binding.progressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoginClickListener()
        observe(viewModel.loginResponse, ::navigateToVerification)
    }

    private fun navigateToVerification(any: Any) {
        findNavController().navigate(
            LoginFragmentDirections.actionLoginFragmentToVerifyCodeFragment()
        )
    }

    private fun onLoginClickListener() {
        binding.login.setOnClickListener {
            viewModel.apply {
                mobileNumber = binding.phoneNumber.cleanText()
                signInWithPhoneNumber()
            }
        }
    }

    private fun onUserLogin() {
        findNavController().navigate(
            LoginFragmentDirections
                .actionLoginFragmentToVerifyCodeFragment()
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}