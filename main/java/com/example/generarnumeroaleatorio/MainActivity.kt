package com.example.generarnumeroaleatorio

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var etIngresarNumero: EditText? = null

    private var tvTotalPuntajes: TextView? = null
    private var tvAdivineNum:TextView? = null
    private var numero: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etIngresarNumero = findViewById(R.id.etIngresarNum) as EditText
        tvTotalPuntajes = findViewById(R.id.tvTotalPuntaje) as TextView
        tvAdivineNum = findViewById(R.id.tvAdivine) as TextView
        val prefe = getSharedPreferences("datos", Context.MODE_PRIVATE)
        val v = prefe.getInt("puntos", 0).toString()
        tvTotalPuntaje!!.setText(v)
        numero = 1 + (Math.random() * 50).toInt()

        btnVerificar.setOnClickListener{
            val valor = Integer.parseInt(etIngresarNum.getText().toString())
            if (numero == valor) {
                var puntosactual = Integer.parseInt(
                    tvTotalPuntaje.getText()
                        .toString()
                )
                puntosactual++
                tvTotalPuntaje.setText(puntosactual.toString())
                tvAdivine.setText("¡¡¡ Usted ha GANADO !!!")
                etIngresarNum.setText("")
                val preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE)
                val editor = preferencias.edit()
                editor.putInt("puntos", puntosactual)
                editor.commit()
                numero = 1 + (Math.random() * 50).toInt()
            } else {
                if (valor > numero) {
                    tvAdivine.setText("El número que ha ingresado es MAYOR ")
                } else {
                    tvAdivine.setText("El número que ha ingresado es MENOR")
                }
            }

        }
    }
}
