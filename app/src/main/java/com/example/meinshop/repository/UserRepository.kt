package com.example.meinshop.repository

class UserRepository {

    val loginUsers = listOf(
        User("loginUser1", "password1"),
        User("loginUser2", "password2"),
        User("loginUser3", "password3"),
        User("loginUser4", "password4"),
        User("loginUser5", "password5"),
    )

    val registerUsers = listOf(
        User("registerUser1", "password1", "John", "Doe", "123 Main St", "01-01-1980", 1000.0, 180.0, 70.0, 40.0, 100.0, 80.0, 50.0, 20.0, 90.0, 30.0, 32.0, 30.0, 28.0, 40.0, "L", 42.0),
        User("registerUser2", "password2", "Jane", "Smith", "456 Pine St", "02-02-196", 2000.0, 170.0, 60.0, 87.0, 95.0, 75.0, 48.0, 18.0, 85.0, 28.0, 31.0, 18.0, 26.0, 38.0, "M", 40.0),
        User("registerUser3", "password3", "Jim", "Benz", "24 Alber St", "22-12-2000", 4000.0, 190.0, 90.0, 38.0, 95.0, 75.0, 48.0, 17.0, 85.0, 38.0, 30.0, 28.0, 22.0, 35.0, "M", 40.0),
        User("registerUser4", "password4", "Andrea", "Merz", "4 Wallner St","07-08-1996", 5000.0, 172.0, 76.0, 38.0, 95.0, 75.0, 48.0, 18.0, 85.0, 18.0, 30.0, 28.0, 26.0, 37.4, "M", 40.0),
        User("registerUser5", "password5", "Jane", "Nesa", "12 Erl St", "18-04-1984", 2000.0, 182.0, 112.0, 38.0, 95.0, 75.0, 48.0, 18.0, 85.0, 28.0, 28.0, 27.10, 26.7, 38.2, "M", 40.0),
    )
}