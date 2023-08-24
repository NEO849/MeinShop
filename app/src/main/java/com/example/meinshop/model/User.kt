package com.example.meinshop.model

data class User (
    val userName: String,
    val password: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    var adress: String,
    val dateOfBirth: String,
    var accountBalance: Double,
    var body_groesse: Double,
    var body_gewichtt: Double,
    var body_schuterZuSchulter: Double,
    var body_brustUmfang: Double,
    var body_hueftUmfang: Double,
    var body_huefteZuHals: Double,
    var body_handgelenkZuHals: Double,
    var body_bauchUmfang: Double,
    var jeans_weite: Double,
    var jeans_laenge: Double,
    var anzug_hose: Double,
    var anzug_sacko: Double,
    var tshirt: Double,
    var schuhgroesse: Double
)