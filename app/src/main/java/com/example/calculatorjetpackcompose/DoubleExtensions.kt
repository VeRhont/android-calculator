package com.example.calculatorjetpackcompose

import kotlin.math.pow


fun Double.round(decimalPlaces: Int): Double {
    val n = 10.0.pow(decimalPlaces.toDouble())
    return Math.round(this * n) / n
}


fun Double.isInt(): Boolean {
    return this.toString().endsWith(".0")
}