package com.caiorocha.app_praca.data.Network

//import android.util.Log
//import com.caiorocha.app_praca.data.DataResponse
//import com.caiorocha.app_praca.ui.viewmodel.NowViewModel
//import com.google.firebase.database.DataSnapshot
//import com.google.firebase.database.DatabaseError
//import com.google.firebase.database.FirebaseDatabase
//import com.google.firebase.database.ValueEventListener
//
//val TAG = "FIREBASEAPI"
//val database = FirebaseDatabase.getInstance()
//val myRef = database.getReference("estabelecimentos")
//
//fun CallFireBase() {
//    myRef.addValueEventListener(object : ValueEventListener {
//        override fun onDataChange(dataSnapshot: DataSnapshot) {
//            val estabelecimento = dataSnapshot.getValue(DataResponse::class.java)
//            // Faça algo com o usuário
//            val nome = estabelecimento?.nome
//            val url = estabelecimento?.urlPhoto
//            val tipo = estabelecimento?.tipo
//            val horario = estabelecimento?.horario
//            val referencia = estabelecimento?.referencia
//
//            if (nome != null && url != null && tipo != null && horario != null && referencia != null) {
//                Log.d(
//                    TAG,
//                    "RESPONSE - Name: $nome, URL: $url, TIPO: $tipo, HORARIO: $horario, REFERENCIA: $referencia"
//                )
//
//                NowViewModel.init(nome, url, tipo, horario, referencia)
//            } else {
//                Log.e("APIERRO", "onFailure: ERRO")
//            }
//        }
//
//        override fun onCancelled(error: DatabaseError) {
//            // Falha na leitura dos valores
//            Log.w(TAG, "FALHA NA LEITURA DOS VALORES.", error.toException())
//        }
//    })
//}
