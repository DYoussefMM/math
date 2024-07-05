package com.example.math

class FuncionExponencial : FuncionTaylor() {
    override fun calculateTerm(x: Double, n: Int): Double {
        return pow(x, n) / factorial(n)
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
