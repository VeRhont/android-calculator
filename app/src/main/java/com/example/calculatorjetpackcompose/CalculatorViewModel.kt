package com.example.calculatorjetpackcompose

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.exp
import kotlin.math.pow


class CalculatorViewModel : ViewModel() {

    var expression by mutableStateOf("0")
        private set

    var lastExpression by mutableStateOf("")
        private set

    private fun getResult() = Model.getCalculatedResult(expression)

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
        val result = Model.getSquare(expression)
        showLastExpression("${getResult()}²=$result")
        expression = result
    }

    fun sqrt() {
        val result = Model.getSqrt(expression)
        showLastExpression("√${getResult()}=$result")
        expression = result
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

    private fun showLastExpression(lastResult: String) {
        lastExpression = lastResult
    }

    fun showResult() {
        val result = getResult()

        showLastExpression("$expression=$result")
        expression = result
    }
}