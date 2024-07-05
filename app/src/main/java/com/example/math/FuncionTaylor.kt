package com.example.math

abstract class FuncionMaclaurin {
    abstract fun calculateTerm(x: Double, n: Int): Double
    abstract fun getInterval(): String

    fun calculateSeries(x: Double, terms: Int): Double {
        var sum = 0.0
        for (n in 0 until terms) {
            sum += calculateTerm(x, n)
        }
        return sum
    }

    protected open fun factorial(n: Int): Double {
        var result = 1.0
        for (i in 2..n) {
            result *= i.toDouble()
        }
        return result
    }

    protected open fun pow(base: Double, exp: Int): Double {
        var result = 1.0
        for (i in 1..exp) {
            result *= base
        }
        return result
    }
}
