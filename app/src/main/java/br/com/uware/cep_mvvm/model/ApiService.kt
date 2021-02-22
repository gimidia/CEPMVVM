package br.com.uware.cep_mvvm.model

import retrofit2.http.GET

/**
 *   Author:     Gilberto Soares
 *   Github:     https://github.com/gimidia
 *   Project:    CEP-MVVM
 *   Date:       15/02/21
 */

interface ApiService {

    @GET("json/")
    suspend fun getCep(): Cep

}