package com.example.math

class FuncionSeno : FuncionTaylor() {
    override fun calculateTerm(x: Double, n: Int): Double {
        return if (n % 2 == 0) {
            0.0 // Términos pares son 0 en la serie de Maclaurin para sin(x)
        } else {
            pow(-1.0, (n - 1) / 2) * pow(x, n) / factorial(n)
        }
    }

    override fun getInterval(): String {
        return "(-∞, ∞)"
    }
}
