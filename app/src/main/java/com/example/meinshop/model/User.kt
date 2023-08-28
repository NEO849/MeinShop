package com.example.meinshop.model

data class User (
    val userName: String,
    val password: String,
    val email: String = "",
    val firstName: String = "",
    val lastName: String = "",
    var adress: String = "",
    val dateOfBirth: String = "",
    var accountBalance: Double = 0.0,
    var body_groesse: Double = 0.0,
    var body_gewichtt: Double = 0.0,
    var body_schuterZuSchulter: Double = 0.0,
    var body_brustUmfang: Double = 0.0,
    var body_hueftUmfang: Double = 0.0,
    var body_huefteZuHals: Double = 0.0,
    var body_handgelenkZuHals: Double = 0.0,
    var body_bauchUmfang: Double = 0.0,
    var jeans_weite: Int = 0,
    var jeans_laenge: Int = 0,
    var anzug_hose: Int = 0,
    var anzug_sacko: Int = 0,
    var tshirt: String = "",
    var schuhgroesse: Int = 0,
)

