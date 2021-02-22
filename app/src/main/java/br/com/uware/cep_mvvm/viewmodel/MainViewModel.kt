package br.com.uware.cep_mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.uware.cep_mvvm.model.ApiHelper
import br.com.uware.cep_mvvm.model.Cep
import br.com.uware.cep_mvvm.model.RetrofitBuilder
import kotlinx.coroutines.launch

/**
 *   Author:     Gilberto Soares
 *   Github:     https://github.com/gimidia
 *   Project:    CEP-MVVM
 *   Date:       15/02/21
 */

class MainViewModel : ViewModel() {

    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Boolean>()
    val errorType = MutableLiveData<Int>()
    val cep = MutableLiveData<Cep>()

    // Recebendo CEP
    fun setCep(cep: String?){
        if (cep != null) {
            fetchCep(cep)
        }
    }

    // Pegando CEP com coroutines
    private fun fetchCep(str: String) {
        loading.value = true
        // Corroutine
        viewModelScope.launch {
            try {
                val currentCep = ApiHelper(RetrofitBuilder(str).apiService).getCep()
                if(currentCep.erro != null){
                    error.value = true
                    errorType.value = 1
                    loading.value = false
                }else {
                    cep.value = currentCep
                    error.value = false
                    loading.value = false
                }
            }catch (e: Exception){
                error.value = true
                errorType.value = 0
                loading.value = false
            }
        }
    }
}