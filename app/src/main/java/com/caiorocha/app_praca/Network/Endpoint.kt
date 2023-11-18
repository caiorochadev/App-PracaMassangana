package com.caiorocha.app_praca.Network

import com.caiorocha.app_praca.data.DataResponseMock
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {
    @GET("/api/v2/pokemon")
    fun getData() : Call<DataResponseMock>
}