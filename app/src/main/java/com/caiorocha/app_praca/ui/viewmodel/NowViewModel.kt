package com.caiorocha.app_praca.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.caiorocha.app_praca.data.DataResponseMock
import com.caiorocha.app_praca.data.ResultMock

// ViewModel para gerenciar o estado da lista
class NowViewModel : ViewModel() {

    val results: List<DataResponseMock>
        get() = _listResults


    companion object {

        fun init(name: String, url: String) {
            getAllResults(name, url)
        }

        val _listResults = mutableStateListOf<DataResponseMock>()

        private fun getAllResults(name: String, url: String) {
            val result = DataResponseMock(
                count = 10,
                next = "próximo",
                previous = "anterior",
                results = listOf(ResultMock(name = name, url = url))
            )

            _listResults.add(result)
        }
    }
}
