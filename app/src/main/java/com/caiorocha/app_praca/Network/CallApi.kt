package com.caiorocha.app_praca.Network

import android.annotation.SuppressLint
import android.util.Log
import com.caiorocha.app_praca.data.DataResponseMock
import com.caiorocha.app_praca.ui.viewmodel.NowViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private val baseURL = "https://pokeapi.co/"
private val tag: String = "CHECK_RESPONSE"

@SuppressLint("SuspiciousIndentation")
fun getListData() {
    val retrofitClient = NetworkUtils.getRetrofitInstance(baseURL)
    val endpoint = retrofitClient.create(Endpoint::class.java) //passando interface

    endpoint.getData().enqueue(object : Callback<DataResponseMock> {
        override fun onResponse(
            call: Call<DataResponseMock>,
            response: Response<DataResponseMock>
        ) {
            response.body()?.results?.forEach { resultMock ->
                val name = resultMock.name
                val url = resultMock.url

                Log.i(tag, "RESPONSE - Name: $name, URL: $url")

                NowViewModel.init(name, url) //chamada da vm dentro da api
            }
        }

        override fun onFailure(call: Call<DataResponseMock>, t: Throwable) {
            Log.i(tag, "onFailure: ${t.message}")
        }
    })
}