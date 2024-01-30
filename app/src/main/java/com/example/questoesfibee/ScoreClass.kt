package com.example.questoesfibee

import java.io.Serializable

data class UserResults(
    val hits : String,
    val errors : String,
    val finalScore : String

) : Serializable
