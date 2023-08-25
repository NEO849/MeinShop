package com.example.meinshop.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.meinshop.utils.LoginUtils
import com.example.meinshop.utils.UserUtils

class LoginViewModel : ViewModel() {

    // LiveData für den Login-Status
    val loginStatus = MutableLiveData<Boolean>()

    // Instanzen der Hilfsklassen
    private val loginUtils = LoginUtils()
    private val userUtils = UserUtils()

    fun login(userName: String, password: String) {
        // Validierung der Benutzereingabe
        if (loginUtils.validateLogin(userName, password)) {
            // Überprüfung der Anmeldeinformationen
            val user = userUtils.getUser(userName, password)
            loginStatus.value = user != null
        } else {
            loginStatus.value = false  // Fehlerhafte Eingabe
        }
    }
}