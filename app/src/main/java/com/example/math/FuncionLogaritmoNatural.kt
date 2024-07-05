package com.example.math

class FuncionLogaritmoNatural : FuncionMaclaurin() {
    override fun calculateTerm(x: Double, n: Int): Double {
        return if (n == 0) {
            0.0 // El término n=0 es 0 en la serie de Maclaurin para ln(1+x)
        } else {
            pow(-1.0, n + 1) * pow(x, n) / n.toDouble()
        }
    }

    override fun getInterval(): String {
        return "(-1, 1)" // Intervalo de convergencia
    }
}
