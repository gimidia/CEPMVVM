package br.com.uware.cep_mvvm.model

/**
 *   Author:     Gilberto Soares
 *   Github:     https://github.com/gimidia
 *   Project:    CEP-MVVM
 *   Date:       15/02/21
 */

class ApiHelper(private val apiService: ApiService) {
    suspend fun getCep() = apiService.getCep()
}