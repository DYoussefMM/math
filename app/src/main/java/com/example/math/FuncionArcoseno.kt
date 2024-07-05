package com.example.math

class FuncionArcoseno : FuncionMaclaurin() {
    override fun calculateTerm(x: Double, n: Int): Double {
        return if (n % 2 == 0) {
            pow(x, 2 * n) * doubleFactorial(2 * n - 1) / (pow(4.0, n) * (2 * n + 1))
        } else {
            0.0 // Términos pares son 0 en la serie de Maclaurin para sin⁻¹(x)
        }
    }

    override fun getInterval(): String {
        return "(-1, 1)" // Intervalo de convergencia
    }

    private fun doubleFactorial(n: Int): Double {
        var result = 1.0
        for (i in n downTo 1 step 2) {
            result *= i.toDouble()
        }
        return result
    }
}
