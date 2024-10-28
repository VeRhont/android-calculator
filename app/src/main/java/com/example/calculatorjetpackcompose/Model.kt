package com.example.calculatorjetpackcompose

class Model {

    companion object {

        fun calculateResult(expression: String): Double {
            return f(expression)
        }

        private fun f(str: String, index: Int = 0, seq: String = "+-*/"): Double {

            if ((index == seq.length) || (!str.contains(Regex("[+*/-]")))) {
                return str.toDouble()
            }

            val elements = mutableListOf<Double>()
            str.split(seq[index]).forEach {
                elements.add(f(it, index + 1))
            }

            when (seq[index]) {
                '+' -> {
                    return elements.reduce { a, b -> a + b }
                }
                '-' -> {
                    return elements.reduce { a, b -> a - b}
                }
                '*' -> {
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