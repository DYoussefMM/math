package com.example.math

class FuncionArcotangenteInversa : FuncionMaclaurin() {
    override fun calculateTerm(x: Double, n: Int): Double {
        return pow(-1.0, (n - 1) / 2) * pow(x, 2 * n - 1) / (2 * n - 1)
    }

    override fun getInterval(): String {
        return "(-1, 1)"
    }
}
