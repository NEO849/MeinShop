package com.example.meinshop.utils

import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.meinshop.databinding.FragmentRegistrierenBinding
import com.example.meinshop.model.User

class RegistrierenUtils {

    // Methode zur Validierung der Benutzereingabe
    fun validateRegistration(user: User): Boolean {
        return user.userName.isNotEmpty() && user.password.isNotEmpty() && user.email.isNotEmpty()
    }

    // Methode zur Anzeige einer Fehlermeldung und erneutem Versuch
    fun showErrorAndRetryRegister(binding: FragmentRegistrierenBinding) {
        binding.errorRegisterCV.visibility = View.VISIBLE
        Handler(Looper.getMainLooper()).postDelayed({
            binding.errorRegisterCV.visibility = View.GONE
        }, 2000)
    }
}