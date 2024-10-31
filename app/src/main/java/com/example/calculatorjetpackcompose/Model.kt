package com.example.calculatorjetpackcompose

import kotlin.math.pow


class Model {

    companion object {

        fun getCalculatedResult(expression: String): String {
            val result = calculateResult(expression)

            if (result == Double.NEGATIVE_INFINITY) {
                return "You can't divide by zero"
            }

            if (result.isInt())
                return result.toInt().toString()

            return result.toString()
        }

        fun power(expression: String, power: Double): String {
            var result = calculateResult(expression)
            result = result.pow(power).round(6)

            if (result.isInt())
                return result.toInt().toString()

            return result.toString()
        }

        private fun calculateResult(expression: String): Double {
            if (expression.isEmpty())
                return 0.0

            val result = splitAndCalculate(expression)
            if (result == Double.NEGATIVE_INFINITY)
                return result

            return result.round(6)
        }

        private fun splitAndCalculate(str: String, index: Int = 0, seq: String = "+-⨯/"): Double {

            if ((index == seq.length) || (!str.contains(Regex("[+⨯/-]"))))
                return str.toDouble()

            val elements = mutableListOf<Double>()
            str.split(seq[index]).forEach {
                elements.add(splitAndCalculate(it, index + 1))
            }

            when (seq[index]) {
                '+' -> return elements.reduce { a, b -> a + b }
                '-' -> return elements.reduce { a, b -> a - b }
                '⨯' -> return elements.reduce { a, b -> a * b }
                '/' -> {
                    if (elements.contains(0.0) && (elements[0] != 0.0))
                        return Double.NEGATIVE_INFINITY

                    return elements.reduce { a, b -> a / b }
                }
                else -> throw Exception("Operations failed")
            }
        }
    }
}