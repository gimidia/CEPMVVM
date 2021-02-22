package br.com.uware.cep_mvvm.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import br.com.uware.cep_mvvm.R
import br.com.uware.cep_mvvm.util.MaskEditUtil
import br.com.uware.cep_mvvm.util.hideKeyboard
import br.com.uware.cep_mvvm.util.loadFragment
import br.com.uware.cep_mvvm.util.snackBar
import br.com.uware.cep_mvvm.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    // ViewModel
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adicionando máscara no EditText
        etCep.addTextChangedListener(MaskEditUtil.mask(etCep))

        // Funções do botão enviar
        btnSend.setOnClickListener {
            // Esconde o teclado
            it.hideKeyboard()
            if(etCep.text.toString().length == 9) {
                // Enviando CEP para o ViewModel
                viewModel.setCep(etCep.text.toString())
                tvInit.visibility = View.GONE
                MainFragment.newInstance().loadFragment(this)
            }
            else {
                it.snackBar(getString(R.string.error_numbers))
            }
        }
    }
}