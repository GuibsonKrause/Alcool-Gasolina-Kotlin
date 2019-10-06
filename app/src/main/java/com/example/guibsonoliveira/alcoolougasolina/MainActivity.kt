package com.example.guibsonoliveira.alcoolougasolina

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalcular = buttonCalcular.setOnClickListener(View.OnClickListener {
            val precoAlcool = editPrecoAlcool.text.toString()
            val precoGasolina = editPrecoGasolina.text.toString()

            if (validarCampos(precoAlcool, precoGasolina))
                calcularMelhorPreco(precoAlcool, precoGasolina)
            else
                textResultado.setText("Preencha os preços primeiro!")
        })
    }

    fun validarCampos(pAlcool: String, pGasolina: String) : Boolean
    {
        if (pAlcool == null || pAlcool.equals(""))
            return false
        else if (pGasolina == null || pGasolina.equals(""))
            return false
        return true
    }

    fun calcularMelhorPreco(pAlcool: String, pGasolina: String)
    {
        val resultadoPreco = pAlcool.toDouble() / pGasolina.toDouble()

        if (resultadoPreco >= 0.7)
            textResultado.setText("Melhor utilizar Gasolina!")
        else
            textResultado.setText("Melhor utilizar Álcool!")
    }
}
