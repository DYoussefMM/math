package com.example.math

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etValorX: EditText
    private lateinit var etNumeroTerminos: EditText
    private lateinit var spinnerFunciones: Spinner
    private lateinit var btnCalcular: Button
    private lateinit var btnFraccion: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etValorX = findViewById(R.id.etValorX)
        etNumeroTerminos = findViewById(R.id.etNumeroTerminos)
        spinnerFunciones = findViewById(R.id.spinnerFunciones)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnFraccion = findViewById(R.id.btnFraccion)

        // Configurar el ArrayAdapter para el Spinner
        val funcionesArray = resources.getStringArray(R.array.funciones_array)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, funcionesArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerFunciones.adapter = adapter

        btnFraccion.setOnClickListener {
            mostrarDialogoFraccion()
        }

        btnCalcular.setOnClickListener {
            calcularSerieTaylor()
        }
    }

    private fun mostrarDialogoFraccion() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_fraction, null)
        val etNumerator = dialogView.findViewById<EditText>(R.id.etNumerator)
        val etDenominator = dialogView.findViewById<EditText>(R.id.etDenominator)
        val btnPi = dialogView.findViewById<Button>(R.id.btnPi)

        val dialog = AlertDialog.Builder(this)
            .setTitle("Ingrese una fracción o seleccione π")
            .setView(dialogView)
            .setPositiveButton("OK") { _, _ ->
                val numerator = etNumerator.text.toString()
                val denominator = etDenominator.text.toString()

                if (numerator.isNotEmpty() && denominator.isNotEmpty()) {
                    val fraction = numerator.toDouble() / denominator.toDouble()
                    etValorX.setText(fraction.toString())
                }
            }
            .setNegativeButton("Cancelar", null)
            .create()

        btnPi.setOnClickListener {
            etValorX.setText(Math.PI.toString())
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun calcularSerieTaylor() {
        val xStr = etValorX.text.toString()
        val nStr = etNumeroTerminos.text.toString()

        if (xStr.isEmpty() || nStr.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        val x = xStr.toDouble()
        val n = nStr.toInt()

        val funcion: FuncionTaylor = when (spinnerFunciones.selectedItem.toString()) {
            "e^x" -> FuncionExponencial()
            "sin(x)" -> FuncionSeno()
            "cos(x)" -> FuncionCoseno()
            "tan^-1(x)" -> FuncionArcotangenteInversa()
            "sin^-1(x)" -> FuncionArcoseno()
            "cos^-1(x)" -> FuncionArcocoseno()
            "ln(1 + x)" -> FuncionLogaritmoNatural()
            "sinh(x)" -> FuncionSenoHiperbolico()
            "cosh(x)" -> FuncionCosenoHiperbolico()
            "tanh^-1(x)" -> FuncionArcotangenteHiperbolicaInversa()
            "coth^-1(x)" -> FuncionCotangenteHiperbolicaInversa()
            "e^sin(x)" -> FuncionExponencialDeSeno()
            "e^cos(x)" -> FuncionExponencialDeCoseno()
            else -> throw IllegalArgumentException("Función no soportada")
        }

        val resultado = funcion.calculateSeries(x, n)
        Toast.makeText(this, "Resultado: $resultado", Toast.LENGTH_LONG).show()
    }
}
