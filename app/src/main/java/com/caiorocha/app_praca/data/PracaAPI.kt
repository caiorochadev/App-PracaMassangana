package com.caiorocha.app_praca.data

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val BASE_URL = "https://raw.githubusercontent.com/caiorochadev/api-praca/main/pracaAPI.json"
private val TAG: String = "CHECK_RESPONSE"

interface PracaAPI {
    @GET("data")
    fun getdata(): Call<List<addResponse>>
}

private fun getData(){
    var api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PracaAPI::class.java)

    api.getdata().enqueue(object : Callback<List<addResponse>>{
        override fun onResponse(
            call: Call<List<addResponse>>,
            response: Response<List<addResponse>>
        ) {
            if(response.isSuccessful){
                response.body()?.let {
                    for(data in it){
                        Log.i(TAG, "onResponse: ${data.nome}")
                    }
                }
            }
        }

        override fun onFailure(call: Call<List<addResponse>>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })
}
