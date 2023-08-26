package com.example.meinshop.repository

import com.example.meinshop.model.User

class UserRepository {

    // Veränderbare Liste von Benutzern
    val loginUsers = mutableListOf(
        User("user1", "password1", "example@1.com", "John", "Doet", "123 Main St", "01-01-1980",10000.0, 87.7, 93.2, 87.4, 45.0, 67.0, 76.34, 45.3, 54.0, 30, 32, 54, 52, "L", 40),
        User("user2", "password2", "example@2.com", "Jane", "Doet", "123 Main St", "11-11-1984",10000.0, 87.7, 93.2, 87.4, 45.0, 67.0, 76.34, 45.3, 54.0, 30, 32, 54, 52, "m", 40),
        User("user3", "password3", "example@3.com", "Mai", "Tai", "Wagner Str.3", "08-04-1990",10000.0, 87.7, 93.2, 87.4, 45.0, 67.0, 76.34, 45.3, 54.0, 30, 32, 54, 52, "XL", 40),
        User("user4", "password4", "example@4.com", "Cuba", "Libre", "Main Str.45", "21-03-1987",10000.0, 87.7, 93.2, 87.4, 45.0, 67.0, 76.34, 45.3, 54.0, 30, 32, 54, 52, "S", 40),
        User("user5", "password5", "example@5.com", "Tim", "Strup", "Elner Weg 3", "18-11-2000",10000.0, 87.7, 93.2, 87.4, 45.0, 67.0, 76.34, 45.3, 54.0, 30, 32, 54, 52, "L", 40)
    )

    // Methode zum Hinzufügen eines neuen Benutzers
    fun addUser(user: User) {
        loginUsers.add(user)
    }
}