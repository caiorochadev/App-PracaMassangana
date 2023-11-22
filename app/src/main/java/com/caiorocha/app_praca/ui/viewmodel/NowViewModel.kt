package com.caiorocha.app_praca.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class DataResponse(
    val urlPhoto: String?,
    val nome: String?,
    val tipo: String,
    val horario: String,
    val referencia: String
)
class NowViewModel : ViewModel() {

    val results: List<DataResponse>
        get() = _listResults

    companion object {

        fun init(
            nome: String?,
            url: String?,
            tipo: String,
            horario: String,
            referencia: String
        ) {
            getAllResults(nome, url, tipo, horario, referencia)
        }

        val _listResults = mutableStateListOf<DataResponse>()

        private fun getAllResults(
            nome: String?,
            url: String?,
            tipo: String,
            horario: String,
            referencia: String
        ) {
            val result = DataResponse(
                urlPhoto = url,
                nome = nome,
                tipo = tipo,
                horario = horario,
                referencia = referencia
            )

            _listResults.add(result)
        }
    }
}
