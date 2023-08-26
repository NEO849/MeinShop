package com.example.meinshop.viewModel

import androidx.lifecycle.ViewModel
import com.example.meinshop.repository.UserRepository
import com.example.meinshop.model.User

class RegistrierViewModel : ViewModel() {

    // Instanz des UserRepository
    val userRepository = UserRepository()

    // Methode zum Registrieren eines neuen Benutzers, Parameter ist das User_Objekt
    fun registerUser(user: User) {
        // Hinzufügen des neuen Benutzers zur Liste
        userRepository.addUser(user)
    }
}