package com.example.meinshop.utils

import com.example.meinshop.model.User
import com.example.meinshop.repository.UserRepository

// Hilfsklasse für Benutzeroperationen
class UserUtils {

    // Instanz des UserRepository
    private val userRepository = UserRepository()

    // Methode zum Abrufen eines Benutzers basierend auf Benutzername und Passwort
    fun getUser(userName: String, password: String): User? {
        return userRepository.loginUsers.find { it.userName == userName && it.password == password }
    }
}