package com.example.meinshop.viewModel

import androidx.lifecycle.ViewModel
import com.example.meinshop.repository.UserRepository
import com.example.meinshop.model.User

class RegistrierViewModel : ViewModel() {

    // Instanz des UserRepository
    private val userRepository = UserRepository()

    // Methode zum Registrieren eines neuen Benutzers
    fun registerUser(username: String, password: String, email: String) {
        // Erstellen eines neuen Benutzerobjekts
        val newUser = User(username, password, email)
        // Hinzufügen des neuen Benutzers zur Liste
        userRepository.addUser(newUser)
    }
}