package com.example.meinshop.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.meinshop.R
import com.example.meinshop.databinding.FragmentRegistrierenBinding
import com.example.meinshop.model.User
import com.example.meinshop.utils.RegistrierenUtils
import com.example.meinshop.viewModel.RegistrierViewModel

class RegistrierenFragment : Fragment(R.layout.fragment_registrieren) {

    private lateinit var binding: FragmentRegistrierenBinding
    private lateinit var viewModel: RegistrierViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegistrierenBinding.bind(view)
        viewModel = ViewModelProvider(this).get(RegistrierViewModel::class.java)

        // OnClickListener für den Registrierungsbutton
        binding.registerBTN.setOnClickListener {
            val username = binding.usernameRegisterTEF.text.toString()
            val email = binding.emailRegisterTEF.text.toString()
            val password = binding.passwortRegisterTEF.text.toString()

            val newUser = User(username, password, email)

            if (RegistrierenUtils().validateRegistration(newUser)) {
                viewModel.registerUser(username, password, email)
                findNavController().navigate(R.id.action_registerFragment_to_welcomeFragment)
            } else {
                RegistrierenUtils().showErrorAndRetryRegister(binding)
            }
        }
    }
}