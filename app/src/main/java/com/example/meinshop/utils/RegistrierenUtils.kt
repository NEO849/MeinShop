package com.example.meinshop.utils

import android.os.Handler
import android.os.Looper
import android.util.Patterns
import android.view.View
import com.example.meinshop.databinding.FragmentRegistrierenBinding
import com.example.meinshop.model.User
import com.example.meinshop.repository.UserRepository

class RegistrierenUtils {

    // Methode zur Validierung der Benutzereingabe
    fun validateRegister(user: User, confirmPassword: String, userRepository: UserRepository): Boolean {

        // Überprüft ob der Benutzername bereits existiert, durchläuft die Liste der registrierten Benutzer und vergleicht die Benutzernamen
        for (existingUser in userRepository.loginUsers) {
            if (existingUser.userName == user.userName) return false  // Benutzername bereits vorhanden
        }

        // Überprüft ob die E-Mail gültig ist, verwendet Android's Patterns Klasse zur Überprüfung des E-Mail-Formats
        if (!Patterns.EMAIL_ADDRESS.matcher(user.email).matches()) return false  // Ungültige E-Mail

        // Überprüft ob das Passwort mindestens 8 Zeichen lang ist
        if (user.password.length < 8) return false

        // Überprüft ob das Passwort und das bestätigte Passwort übereinstimmen
        if (user.password != confirmPassword) return false  // Passwörter stimmen nicht überein

        return true  // Alle Validierungen erfolgreich
    }

    // Methode zur Anzeige einer Fehlermeldung und erneuten Versuch der Registrierung
    fun showErrorAndRetryRegister(binding: FragmentRegistrierenBinding) {
        // Versteckt die Registrierungs-Cardview
        binding.registerCV.visibility = View.GONE
        // Zeigt die Fehler-Cardview an
        binding.errorRegisterCV.visibility = View.VISIBLE

        // Verzögerung von 2 Sekunden, um zur Registrierungs-Cardview zurückzukehren
        Handler(Looper.getMainLooper()).postDelayed({
            // Versteckt die Fehler-Cardview
            binding.errorRegisterCV.visibility = View.GONE
            // Zeigt die Registrierungs-Cardview wieder an
            binding.registerCV.visibility = View.VISIBLE
        }, 2000)  // 2 Sekunden Verzögerung
    }
}