package com.example.calculatorjetpackcompose

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.exp


class CalculatorViewModel: ViewModel() {

    var expression by mutableStateOf("0")
        private set

    fun addDigit(digit: String) {
        if (expression.startsWith("0")) {
            expression = ""
        }
        expression += digit
    }

    fun addOperation(operation: String) {
        if (expression.last().isDigit()) {
            expression += operation
        }
    }

    fun power() {
        val result = Math.pow(Model.calculateResult(expression), 2.0)
        expression = result.toString()
    }

    fun sqrt() {
        val result = Math.sqrt(Model.calculateResult(expression))
        expression = result.toString()
    }

    fun clear() {
        expression = "0"
    }

    fun removeLastSymbol() {
        expression = expression.dropLast(1)
    }

    fun addPoint() {
        if (!expression.contains(".")) {
            expression += "."
        }
    }

    fun getResult() {
        val result = Model.calculateResult(expression)
        expression = result.toString()
    }
}