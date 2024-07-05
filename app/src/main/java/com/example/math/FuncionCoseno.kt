package com.example.math

class FuncionCoseno : FuncionTaylor() {
    override fun calculateTerm(x: Double, n: Int): Double {
        return if (n % 2 != 0) 0.0 else pow(-1.0, n / 2) * pow(x, n) / factorial(n)
    }

    override fun getInterval(): String {
        return "(-∞, ∞)"
    }
}
