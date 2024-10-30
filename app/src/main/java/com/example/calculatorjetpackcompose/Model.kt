package com.example.calculatorjetpackcompose

import kotlin.math.pow


class Model {

    companion object {

        fun getCalculatedResult(expression: String): String {
            val result = calculateResult(expression)

            if (result.isInt())
                return result.toInt().toString()

            return result.toString()
        }

        fun getSqrt(expression: String): String {

            var result = calculateResult(expression)
            result = kotlin.math.sqrt(result).round(6)

            if (result.isInt())
                return result.toInt().toString()

            return result.toString()
        }

        fun getSquare(expression: String): String {

            var result = calculateResult(expression)
            result = result.pow(2.0).round(6)

            if (result.isInt())
                return result.toInt().toString()

            return result.toString()
        }


        private fun calculateResult(expression: String): Double {
            if (expression.isEmpty())
                return 0.0

            return splitAndCalculate(expression).round(6)
        }

        private fun splitAndCalculate(str: String, index: Int = 0, seq: String = "-+⨯/"): Double {

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
                '/' -> return elements.reduce { a, b -> a / b }
                else -> throw Exception("Operations failed")
            }
        }
    }
}