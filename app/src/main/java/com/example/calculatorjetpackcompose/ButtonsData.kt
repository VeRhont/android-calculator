package com.example.calculatorjetpackcompose

import com.example.calculatorjetpackcompose.ui.theme.DarkGray
import com.example.calculatorjetpackcompose.ui.theme.LightGray
import com.example.calculatorjetpackcompose.ui.theme.Orange
import com.example.calculatorjetpackcompose.ui.theme.TextColor


class ButtonsData(viewModel: CalculatorViewModel) {

    val digitButtons = (0..9).map {
        CalcButton(
            text = it.toString(),
            textColor = TextColor,
            backgroundColor = DarkGray,
            borderColor = LightGray,
        ) {
            viewModel.addDigit(it.toString())
        }
    }.toList()

    val operations = mapOf(
        "+" to { viewModel.addOperation("+") },
        "-" to { viewModel.addOperation("-") },
        "⨯" to { viewModel.addOperation("⨯") },
        "/" to { viewModel.addOperation("/") },
        "C" to { viewModel.clear() },
        "√x" to { viewModel.sqrt() },
        "x²" to { viewModel.power() },
        "⌫" to { viewModel.removeLastSymbol() }
    )

    val operationButtons = operations.map {
        it.key to CalcButton(
            text = it.key,
            textColor = TextColor,
            backgroundColor = LightGray,
            borderColor = LightGray
        ) {
            it.value()
        }
    }.toMap()

    val buttons = listOf(
        operationButtons.getValue("C"),
        operationButtons.getValue("√x"),
        operationButtons.getValue("x²"),
        operationButtons.getValue("⌫"),
        digitButtons[7],
        digitButtons[8],
        digitButtons[9],
        operationButtons.getValue("⨯"),
        digitButtons[4],
        digitButtons[5],
        digitButtons[6],
        operationButtons.getValue("-"),
        digitButtons[1],
        digitButtons[2],
        digitButtons[3],
        operationButtons.getValue("+"),
        CalcButton(
            text = "=",
            textColor = TextColor,
            backgroundColor = Orange,
            borderColor = Orange
        ) {
            viewModel.showResult()
        },
        digitButtons[0],
        CalcButton(
            text = ".",
            textColor = TextColor,
            backgroundColor = DarkGray,
            borderColor = LightGray
        ) {
            viewModel.addPoint()
        },
        operationButtons.getValue("/")
    )

    fun getButtonsData(): List<CalcButton> {
        return buttons
    }
}