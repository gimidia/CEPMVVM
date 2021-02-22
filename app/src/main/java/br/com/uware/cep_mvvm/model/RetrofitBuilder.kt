package br.com.uware.cep_mvvm.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *   Author:     Gilberto Soares
 *   Github:     https://github.com/gimidia
 *   Project:    CEP-MVVM
 *   Date:       15/02/21
 */

class RetrofitBuilder(cep: String) {

    private val cep = cep

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://viacep.com.br/ws/${cep}/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}