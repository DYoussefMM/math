package com.example.math

class FuncionSenoHiperbolico : FuncionMaclaurin() {
    override fun calculateTerm(x: Double, n: Int): Double {
        return pow(x, 2 * n + 1) / factorial(2 * n + 1)
    }

    override fun getInterval(): String {
        return "(-∞, ∞)" // Intervalo de convergencia
    }

    override fun factorial(n: Int): Double {
        var result = 1.0
        for (i in 1..n) {
            result *= i.toDouble()
        }
        return result
    }
}
