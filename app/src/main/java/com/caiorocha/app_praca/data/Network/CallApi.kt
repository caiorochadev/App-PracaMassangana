package com.caiorocha.app_praca.data.Network

import android.annotation.SuppressLint
import android.util.Log
import com.caiorocha.app_praca.data.repository.ListItemDB
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET

const val TAG: String = "CHECK_RESPONSE"

interface Endpoint {
    @GET("caiorochadev/api-praca/main/pracaAPI.json")
    fun getData(): Call<ListItemDB>
}
@SuppressLint("SuspiciousIndentation")
fun getListData() {
    val retrofitClient = NetworkUtils.getRetrofitInstance("raw.githubusercontent.com")
    val endpoint = retrofitClient.create(Endpoint::class.java)

    endpoint.getData().enqueue(object : Callback<ListItemDB> {
        override fun onResponse(call: Call<ListItemDB>, response: Response<ListItemDB>) {
            if (response.isSuccessful) {
                val data = response.body()

                if (data != null) {
                    val nome = data.nome
                    val url = data.urlPhoto
                    val tipo = data.tipo
                    val horario = data.horario
                    val referencia = data.referencia

                    Log.i(
                        TAG,
                        "RESPONSE - Name: $nome, URL: $url, TIPO: $tipo, HORARIO: $horario, REFERENCIA: $referencia"
                    )
                } else {
                    Log.e(TAG, "onResponse: Body is null")
                }
            }
        }

        override fun onFailure(call: Call<ListItemDB>, t: Throwable) {
            Log.e(TAG, "onFailure: ${t.message}")
        }
    })
}
