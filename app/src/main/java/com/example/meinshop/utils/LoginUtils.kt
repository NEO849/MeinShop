package com.example.meinshop.utils

// Hilfsklasse für Login-Operationen
class LoginUtils {

    // Methode zur Validierung der Benutzereingabe
    fun validateLogin(userName: String, password: String): Boolean {
        return userName.isNotEmpty() && password.isNotEmpty()
    }
}