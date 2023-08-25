package com.example.meinshop.viewModel

import androidx.lifecycle.ViewModel
import com.example.meinshop.repository.UserRepository

class LoginViewModel : ViewModel() {

    private val userRepository = UserRepository()

    // Überprüft, ob der Benutzer in der Liste der registrierten Benutzer vorhanden ist
    fun isValidUser(username: String, password: String): Boolean {
        // Schleife zum Durchlaufen der Liste der Benutzer
        for (user in userRepository.loginUsers) {
            if (user.userName == username && user.password == password) {
                return true
            }
        }
        return false
    }
}