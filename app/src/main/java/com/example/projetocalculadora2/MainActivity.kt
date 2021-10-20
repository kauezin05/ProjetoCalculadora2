package com.example.projetocalculadora2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.TextView
import android.widget.Toast
import com.example.projetocalculadora2.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.CalcButton.setOnClickListener{ calculate() }
    }
    fun calculate() {

        val stringInTextField1 = binding.Numbers1EditT.text.toString()
        val n1 = stringInTextField1.toDouble()/* Variável que irá  receber e transformar o Number1 em string para poder fazer calculos fracionários */

        val stringInTextField2 = binding.Numbers2EditT.text.toString()
        val n2 = stringInTextField2.toDouble()/* Variável que irá  receber e transformar o Number2 em string para poder fazer calculos fracionários */


        val selectedId = binding.optionsRadioG.checkedRadioButtonId/*Variável que irá  receber o qual radiogrup foi selecionado*/

        val NumberSigns = when (selectedId) { /*When que irá  identificar e fará a conta do radiogrup selecionado*/
            R.id.option_add -> n1 + n2
            R.id.option_sub -> n1 - n2
            R.id.option_mult -> n1 * n2
            else -> n1 / n2 
        }


        val toast = Toast.makeText (this, "Conta realizada", Toast.LENGTH_SHORT).show()/*Toast que irá  mostrar uma mensagem na tela, após efetuar o click do botão*/

        val Result = NumberSigns/*Variável que irá receber o resultado do when*/
        binding.ResultNumbersTextV.text = Result.toString()/*código que irá  passar o resultado para a textview destinada*/

    }
}