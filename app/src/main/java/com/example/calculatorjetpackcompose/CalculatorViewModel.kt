package com.example.calculatorjetpackcompose

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.pow


class CalculatorViewModel : ViewModel() {

    var expression by mutableStateOf("0")
        private set

    var lastExpression by mutableStateOf("")
        private set

    private fun getResult() = Model.calculateResult(expression)

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
        val result = getResult().pow(2.0)
        showLastExpression("${getResult()}²=$result")
        expression = result.toString()
    }

    fun sqrt() {
        val result = kotlin.math.sqrt(getResult()).toString()
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

    private fun showLastExpression(str: String) {
        lastExpression = str
    }

    fun showResult() {
        var result = getResult().toString()

        if (result.contains(".") && (result.endsWith("0"))) {
            result = result.removeSuffix(".0")
        }

        showLastExpression("$expression=$result")
        expression = result
    }
}