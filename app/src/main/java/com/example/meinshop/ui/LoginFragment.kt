package com.example.meinshop.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.meinshop.R
import com.example.meinshop.databinding.FragmentLoginBinding
import com.example.meinshop.utils.LoginUtils
import com.example.meinshop.viewModel.LoginViewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.loginBTN.setOnClickListener {
            val username = binding.usernameLoginTEF.text.toString()
            val password = binding.passwortLoginTEF.text.toString()

            // Überprüfen, ob die Benutzereingaben gültig sind
            if (LoginUtils().validateLogin(username, password)) {

                // Überprüfen, ob der Benutzer in der Liste der registrierten Benutzer vorhanden ist
                if (viewModel.isValidUser(username, password)) {
                    // Navigieren zum WelcomeFragment
                    findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
                } else {
                    // Fehlermeldung anzeigen
                }
            } else {
                // Fehlermeldung anzeigen
            }
        }
    }
}