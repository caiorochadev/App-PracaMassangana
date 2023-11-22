package com.caiorocha.app_praca.data.Network

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FirebaseDataManager {

    private val TAG = "FirebaseDataManager"
    private val databaseReference: DatabaseReference

    init {
        // Inicializar o Firebase no construtor da classe
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        databaseReference = FirebaseDatabase.getInstance().getReference("estabelecimentos")
    }

    fun adicionarListenerDadosEmTempoReal(listener: ValueEventListener) {
        // Adicionar um ValueEventListener para ouvir alterações nos dados em tempo real
        databaseReference.addValueEventListener(listener)
    }

    fun removerListenerDadosEmTempoReal(listener: ValueEventListener) {
        // Remover o ValueEventListener quando não for mais necessário
        databaseReference.removeEventListener(listener)
    }
}
