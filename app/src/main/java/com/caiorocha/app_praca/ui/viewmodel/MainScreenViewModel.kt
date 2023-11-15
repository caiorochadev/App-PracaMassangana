package com.caiorocha.app_praca.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel


data class ListItem(val id: Int,
                    val content: String
)

// ViewModel para gerenciar o estado da lista
class MainViewModel : ViewModel() {
    private val _listItems = mutableStateListOf<ListItem>()

    val listItems: List<ListItem>
        get() = _listItems

    init {
        // Inicializa a lista com alguns itens de exemplo
        repeat(10) {
            _listItems.add(ListItem(it, "Item $it"))
        }
    }

}