package com.example.meinshop.utils

import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.meinshop.databinding.FragmentLoginBinding

// Hilfsklasse für Login-Operationen
class LoginUtils {

    // Methode zur Validierung der Benutzereingabe
    fun validateLogin(userName: String, password: String): Boolean {
        return userName.isNotEmpty() && password.isNotEmpty()
    }

    fun showErrorAndRetry(binding: FragmentLoginBinding) {
        // Fehlermeldung anzeigen
        binding.loginCV.visibility = View.GONE  // Versteckt die Login Cardview
        binding.errorLoginCV.visibility = View.VISIBLE  // Zeigt dafür die error Cardview samt Fehlermeldung an

        // Nach 2 Sekunden zurück zur Login Cardview samt Eingabe felder
        Handler(Looper.getMainLooper()).postDelayed({
            binding.errorLoginCV.visibility = View.GONE  // Versteckt die error Cardview
            binding.loginCV.visibility = View.VISIBLE  // Zeigt dafür wieder die login Cardview samt Fehlermeldung an
        }, 2000)  //  2 Sekunden
    }
}