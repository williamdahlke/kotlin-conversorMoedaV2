package br.ufpr.conversormoedav2

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun convert(view : View){
        val realToDolar = 5.64
        val realToEuro = 6.13
        val dolarToEuro = 0.92
        val euroToDolar = 1.09
        val valor = findViewById<EditText>(R.id.etN1)
        val deReal = findViewById<RadioButton>(R.id.rbDeReal)
        val deDolar = findViewById<RadioButton>(R.id.rbDeDolar)
        val deEuro = findViewById<RadioButton>(R.id.rbDeEuro)
        val paraReal = findViewById<RadioButton>(R.id.rbParaReal)
        val paraDolar = findViewById<RadioButton>(R.id.rbParaDolar)
        val paraEuro = findViewById<RadioButton>(R.id.rbParaEuro)
        val result = findViewById<TextView>(R.id.result)
        var resultado = 0.0

        if (valor.text.toString().isEmpty()){
            Toast.makeText(this, "É necessário informar o valor!", Toast.LENGTH_SHORT).show()
        } else{

            val valorDouble = valor.text.toString().toDouble()

            if (deReal.isChecked){
                if (paraReal.isChecked){
                    Toast.makeText(this, "Você precisa escolher outra moeda. Não é necessário converter o valor para a mesma moeda", Toast.LENGTH_SHORT).show()
                }
                if (paraDolar.isChecked){
                    resultado = valorDouble / realToDolar
                }
                if (paraEuro.isChecked){
                    resultado = valorDouble / realToEuro
                }
            }
            else if (deDolar.isChecked){
                if (paraReal.isChecked){
                    resultado = valorDouble * realToDolar
                }
                if (paraDolar.isChecked){
                    Toast.makeText(this, "Você precisa escolher outra moeda. Não é necessário converter o valor para a mesma moeda", Toast.LENGTH_SHORT).show()
                }
                if (paraEuro.isChecked){
                    resultado = valorDouble * dolarToEuro
                }
            }
            else{
                if (paraReal.isChecked){
                    resultado = valorDouble * realToEuro
                }
                if (paraDolar.isChecked){
                    resultado = valorDouble * euroToDolar
                }
                if (paraEuro.isChecked){
                    Toast.makeText(this, "Você precisa escolher outra moeda. Não é necessário converter o valor para a mesma moeda", Toast.LENGTH_SHORT).show()
                }
            }
        }
        result.text = resultado.toString();
    }
}