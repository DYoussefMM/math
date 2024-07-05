package com.example.math

class FuncionCotangenteHiperbolicaInversa : FuncionTaylor() {
    override fun calculateTerm(x: Double, n: Int): Double {
        return if (n % 2 == 0) 0.0 else 1.0 / (pow(x, n) * n.toDouble())
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
}
