package com.caiorocha.app_praca.data.repository

data class DataResponseMock(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<ResultMock>
)