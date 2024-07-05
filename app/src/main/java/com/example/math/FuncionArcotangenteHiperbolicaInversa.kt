package com.example.math

class FuncionArcotangenteHiperbolicaInversa : FuncionMaclaurin() {
    override fun calculateTerm(x: Double, n: Int): Double {
        return if (n % 2 == 0) {
            0.0 // Términos pares son 0 en la serie de Maclaurin para tanh⁻¹(x)
        } else {
            pow(x, n) / n.toDouble()
        }
    }

    override fun getInterval(): String {
        return "|x| < 1" // Intervalo de convergencia
    }
}
