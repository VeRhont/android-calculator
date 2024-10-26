package com.example.calculatorjetpackcompose

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel



class CalculatorViewModel: ViewModel() {

    var number by mutableStateOf("0")
        private set

    fun addDigit(digit: String) {
        if (number.startsWith("0")) {
            number = ""
        }

        number += digit
    }

    fun addOperation(operation: String) {
        if (number.last().isDigit()) {
            number += operation
        }
    }

    fun changeSign() {
        if (number.startsWith("-")) {
            number = number.removePrefix("-")
        }
        else {
            number = "-$number"
        }
    }

    fun addPoint() {
        if (!number.contains(".")) {
            number += "."
        }
    }

    fun getResult() {
        number = "result"
    }

}