package com.example.meinshop.viewModel

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.meinshop.repository.UserRepository

class LoginViewModel : ViewModel() {

    private val userRepository = UserRepository()

    // Überprüft, ob der Benutzer in der Liste der registrierten Benutzer vorhanden ist
    fun isValidUserFromRepo(username: String, password: String): Boolean {
        // Schleife zum Durchlaufen der Liste der Benutzer
        for (user in userRepository.loginUsers) {
            if (user.userName == username && user.password == password) {
                return true
            }
        }
        return false
    }

    // Überprüft, ob der Benutzer in den SharedPreferences vorhanden ist
    fun isValidUserFromPrefs(context: Context, username: String, password: String): Boolean {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("MeinShopPrefs", Context.MODE_PRIVATE)
        val savedUsername = sharedPreferences.getString("username", null)
        val savedPassword = sharedPreferences.getString("password", null)

        // Log-Ausgabe zum Überprüfen der gespeicherten SharedPreferences
        Log.d("SharedPreferences", "Username: $savedUsername, Password: $savedPassword")
        return username == savedUsername && password == savedPassword
    }
}