package com.example.math

class FuncionArcocoseno : FuncionTaylor() {
    override fun calculateTerm(x: Double, n: Int): Double {
        return if (n % 2 == 0) {
            pow(1.0 - x, n / 2) * doubleFactorial(2 * n - 1) / (pow(4.0, n) * (n + 1).toDouble())
        } else {
            0.0
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
