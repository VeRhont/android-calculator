package com.example.calculatorjetpackcompose

class Model {

    companion object {

        fun calculateResult(expression: String): Double {
            // Rounding a number to 6 decimal places
            val n = 1000000.0
            val result = Math.round(splitAndCalculate(expression) * n) / n

            return result
        }

        private fun splitAndCalculate(str: String, index: Int = 0, seq: String = "+-⨯/"): Double {

            if ((index == seq.length) || (!str.contains(Regex("[+⨯/-]")))) {
                return str.toDouble()
            }

            val elements = mutableListOf<Double>()
            str.split(seq[index]).forEach {
                elements.add(splitAndCalculate(it, index + 1))
            }

            when (seq[index]) {
                '+' -> {
                    return elements.reduce { a, b -> a + b }
                }

                '-' -> {
                    return elements.reduce { a, b -> a - b }
                }

                '⨯' -> {
                    return elements.reduce { a, b -> a * b }
                }

                '/' -> {
                    return elements.reduce { a, b -> a / b }
                }

                else -> throw Exception("Operations failed")
            }
        }
    }
}