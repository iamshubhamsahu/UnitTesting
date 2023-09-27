package com.example.unittesting

object Validator {
    fun validate(userName:String,email: String, password: String): String? {
        if(userName.isEmpty()) return "Plz enter username"
        if(userName.length<6) return "very short username"
        if(userName.length>20) return "very long username"

        if (email.isEmpty()) return "Plz enter email"
        if (!email.contains("@")) return "plz enter valid email"

        if (password.filter { it.isDigit() }.isEmpty()) return "password must contain at least one digit"
        if (password.isEmpty()) return "Very short short"
        if (password.length<6) return "Plz enter valid password"

        return null
    }
}