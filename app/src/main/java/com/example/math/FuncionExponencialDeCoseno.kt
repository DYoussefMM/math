package com.example.math

class FuncionExponencialDeCoseno : FuncionTaylor() {
    override fun calculateTerm(x: Double, n: Int): Double {
        return pow(x, n) / factorial(n) * exp(cos(x))
    }

    override fun getInterval(): String {
        return "(-∞, ∞)" // Intervalo de convergencia
    }

    override fun pow(base: Double, exp: Int): Double {
        var result = 1.0
        for (i in 1..exp) {
            result *= base
        }
        return result
    }

    override fun factorial(n: Int): Double {
        var result = 1.0
        for (i in 1..n) {
            result *= i.toDouble()
        }
        return result
    }

    private fun exp(x: Double): Double {
        var sum = 1.0
        var term = 1.0
        for (i in 1..50) { // Ajustar el número de términos según la precisión deseada
            term *= x / i
            sum += term
        }
        return sum
    }

    private fun cos(x: Double): Double {
        var sum = 1.0
        var term = 1.0
        var sign = -1.0
        for (i in 1..50) { // Ajustar el número de términos según la precisión deseada
            term *= x * x / (2 * i * (2 * i - 1))
            sum += sign * term
            sign *= -1.0
        }
        return sum
    }
}
