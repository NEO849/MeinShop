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

//        // Instanz der LoginUtils Klasse wird benötigt wenn Methodenaufruf so ist:(das L kleingeschrieben und ohne die Klammern) loginUtils.showErrorAndRetry(binding)
//        val loginUtils = LoginUtils()

//        // Zuerst die Fehlermeldung ausblenden, falls sie nicht in der xml Datei auf 2gone" gesetzt worden ist
//        binding.errorLoginCV.visibility = View.GONE

        binding.loginBTN.setOnClickListener {
            val username = binding.usernameLoginTEF.text.toString()
            val password = binding.passwortLoginTEF.text.toString()

            // Überprüft ob die Benutzereingaben gültig sind
            if (LoginUtils().validateLogin(username, password)) {

                // Überprüft ob der Benutzer in der Liste der registrierten Benutzer vorhanden ist
                if (viewModel.isValidUser(username, password)) {
                    // Navigieren zum WelcomeFragment
                    findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
                } else {
                    // Fehlermeldung anzeigen und nach 2 Sekunden zurück zur Login Cardview, samt Eingabefelder
                    LoginUtils().showErrorAndRetry(binding)
                }
            } else {
                // Fehlermeldung anzeigen und nach 2 Sekunden zurück zur Login Cardview, samt Eingabefelder
                LoginUtils().showErrorAndRetry(binding)
            }
        }
    }
}