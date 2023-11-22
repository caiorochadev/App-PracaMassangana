package com.caiorocha.app_praca.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.caiorocha.app_praca.R
import com.caiorocha.app_praca.data.repository.ListItemDB


// ViewModel para gerenciar o estado da lista
class MainViewModel : ViewModel() {
    val _listItemDBS = mutableStateListOf<ListItemDB>()

    val listItemDBS: List<ListItemDB>
        get() = _listItemDBS

    init{
        // Inicializa a lista com alguns itens de exemplo
        repeat(10) {
            _listItemDBS.add(
                ListItemDB(
                urlPhoto = R.drawable.ic_launcher_foreground,
                nome = "Nome",
                tipo = "Tipo Exemplo",
                horario = "Horário Exemplo",
                referencia = "Referência Exemplo"
            )
            )
        }
    }
}
