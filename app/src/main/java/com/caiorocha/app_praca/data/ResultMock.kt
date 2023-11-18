package com.caiorocha.app_praca.data

class ResultMock (
    val name : String,
    val url : String
) {
    override fun toString(): String {
        return "Result(name='$name', Url='$url')"
    }
}