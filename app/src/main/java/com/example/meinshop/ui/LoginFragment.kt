package com.example.meinshop.ui

import android.content.Context
import android.content.SharedPreferences
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

    // Deklaraiere variable für Data Binding und ViewModel
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    private lateinit var sharedPreferences: SharedPreferences  // SharedPreferences-Instanz hinzugefügt

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

//        // Instanz der LoginUtils Klasse wird benötigt wenn Methodenaufruf so ist:(das L kleingeschrieben und ohne die Klammern) loginUtils.showErrorAndRetry(binding)
//        val loginUtils = LoginUtils()

//        // Zuerst die Fehlermeldung ausblenden, falls sie nicht in der xml Datei auf "gone" gesetzt worden ist
//        binding.errorLoginCV.visibility = View.GONE

        // Initialisierung der SharedPreferences
        sharedPreferences = requireActivity().getSharedPreferences("MeinShopPrefs", Context.MODE_PRIVATE)

        // OnClickListener für den "Registrieren" Text
        binding.registerKlickTV.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        // OnClickListener für den Login Button
        binding.loginBTN.setOnClickListener {
            val username = binding.usernameLoginTEF.text.toString()
            val password = binding.passwortLoginTEF.text.toString()

            // Liest die gespeicherten Benutzerdaten aus SharedPreferences
            val savedUsername = sharedPreferences.getString("username", null)
            val savedPassword = sharedPreferences.getString("password", null)

            // Überprüft ob die eingegebenen Daten mit den gespeicherten Daten übereinstimmen
            if (username == savedUsername && password == savedPassword) {
                // Navigiert zum WelcomeFragment, wenn die Anmeldung erfolgreich ist
                findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            } else {
                // Zeigt die error cardView - Fehlermeldung an, wenn die Anmeldung fehlschlägt
                LoginUtils().showErrorAndRetryLogin(binding)
            }
        }
    }
}