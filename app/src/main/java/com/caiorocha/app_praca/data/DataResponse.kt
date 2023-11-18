package com.caiorocha.app_praca.data

data class DataResponse (
    val id: Int,
    val urlPhoto: String,
    val nome: String,
    val tipo: String,
    val horario: String,
    val referencia: String
)