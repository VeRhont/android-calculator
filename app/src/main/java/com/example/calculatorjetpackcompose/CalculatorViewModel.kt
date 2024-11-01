package com.example.calculatorjetpackcompose

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class CalculatorViewModel : ViewModel() {

    var expression by mutableStateOf("0")
        private set

    var lastExpression by mutableStateOf("")
        private set

    private var isNumberFinished = false
    private var containsPoint = false

    private fun getResult(): String {
        if (!expression.last().isDigit())
            return expression

        return Model.getCalculatedResult(expression)
    }

    fun addDigit(digit: String) {
        if (!containsPoint && (expression.last() == '0')) {
            expression = expression.dropLast(1)
        }
        expression += digit
    }

    fun addOperation(operation: String) {
        if (expression.last().isDigit()) {
            expression += operation
        } else if (expression.last().isOperation()) {
            expression = expression.dropLast(1) + operation
        }
        isNumberFinished = true
        containsPoint = false
    }

    fun addPoint() {
        if (expression.last().isOperation())
            return

        if (!containsPoint) {
            expression += "."
            containsPoint = true
        }
    }

    fun removeLastSymbol() {
        if (expression.length == 1) {
            clear()
            return
        }

        if (expression.last().isOperation()) {
            isNumberFinished = false
        }
        if (expression.last() == '.') {
            containsPoint = false
        }
        expression = expression.dropLast(1)
    }

    private fun showLastExpression(lastResult: String) {
        lastExpression = lastResult
    }

    fun showResult() {
        val result = getResult()

        showLastExpression("$expression=$result")
        expression = result
    }

    fun power() {
        val result = Model.power(expression, 2.0)
        showLastExpression("${getResult()}²=$result")
        expression = result
    }

    fun sqrt() {
        val result = Model.power(expression, 0.5)
        showLastExpression("√${getResult()}=$result")
        expression = result
    }

    fun clear() {
        expression = "0"
        isNumberFinished = false
        containsPoint = false
    }
}