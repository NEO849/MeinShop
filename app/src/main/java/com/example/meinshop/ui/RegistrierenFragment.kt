package com.example.meinshop.ui

import android.content.Context
import android.content.SharedPreferences
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

    // Deklaraiere variable für Data Binding und ViewModel
    private lateinit var binding: FragmentRegistrierenBinding
    private lateinit var viewModel: RegistrierViewModel

    // SharedPreferences-Objekt
    private lateinit var sharedPreferences: SharedPreferences

    // Überschreiben der onViewCreated-Methode, die aufgerufen wird, wenn die Ansicht des Fragments erstellt wurde
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialisierung des Data Binding und des ViewModel
        binding = FragmentRegistrierenBinding.bind(view)
        viewModel = ViewModelProvider(this).get(RegistrierViewModel::class.java)

        // Initialisierung des SharedPreferences, in "MeinShopPrefs" werden die Daten gespeichert
        sharedPreferences = requireActivity().getSharedPreferences("MeinShopPrefs", Context.MODE_PRIVATE)

        // OnClickListener für den Registrierungsbutton
        binding.registerBTN.setOnClickListener {
            // Extrahiert die Benutzereingaben aus den Textfeldern und speichert sie in Variablen
            val username = binding.usernameRegisterTEF.text.toString()
            val email = binding.emailRegisterTEF.text.toString()
            val password = binding.passwortRegisterTEF.text.toString()
            val confirmPassword = binding.passwortConfirmRegisterTEF.text.toString()

            // Erstellt ein neues User-Objekt mit den eingegebenen Daten
            val newUser = User(username, password, email)

            // Ruft die validateRegister-Methode aus der RegistrierenUtils-Klasse auf, um die Benutzereingaben zu validieren
            // Wenn die Validierung erfolgreich ist, wird der Benutzer registriert und zur Welcome-Seite weitergeleitet
            if (RegistrierenUtils().validateRegister(newUser, confirmPassword, viewModel.userRepository)) {
                // Speichert die Benutzerdaten in SharedPreferences, durch "apply"- synchrom
                val editor = sharedPreferences.edit()
                editor.putString("username", username)
                editor.putString("email", email)
                editor.putString("password", password)
                editor.apply()
                // Fügt den neuen Benutzer zum UserRepository hinzu
                viewModel.registerUser(newUser)
                // Navigiert zur Welcome-Seite
                findNavController().navigate(R.id.action_registerFragment_to_welcomeFragment)
            } else {
                // Zeigt eine Fehlermeldung an, wenn die Validierung fehlschlägt
                // Ruft die showErrorAndRetryRegister-Methode aus der RegistrierenUtils-Klasse auf
                RegistrierenUtils().showErrorAndRetryRegister(binding)
            }
        }
    }
}