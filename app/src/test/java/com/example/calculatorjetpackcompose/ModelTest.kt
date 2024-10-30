package com.example.calculatorjetpackcompose

import junit.framework.TestCase.assertEquals
import org.junit.Test


class ModelTest {

    @Test
    fun `add two int numbers`() {
        val expression = "1+1"
        val expected = "2"

        val actual = Model.getCalculatedResult(expression)

        assertEquals(expected, actual)
    }

    @Test
    fun `add three double numbers`() {
        val expression = "0.5+0.1+0.6"
        val expected = "1.2"

        val actual = Model.getCalculatedResult(expression)

        assertEquals(expected, actual)
    }

    @Test
    fun `subtract two int numbers`() {
        val expression = "5-3"
        val expected = "2"

        val actual = Model.getCalculatedResult(expression)

        assertEquals(expected, actual)
    }

    @Test
    fun `subtract three double numbers`() {
        val expression = "5.0-2.5-1.1"
        val expected = "1.4"

        val actual = Model.getCalculatedResult(expression)

        assertEquals(expected, actual)
    }


    @Test
    fun `multiply two int numbers`() {
        val expression = "10⨯10"
        val expected = "100"

        val actual = Model.getCalculatedResult(expression)

        assertEquals(expected, actual)
    }

    @Test
    fun `multiply two double numbers`() {
        val expression = "3.33⨯1.2"
        val expected = "3.996"

        val actual = Model.getCalculatedResult(expression)

        assertEquals(expected, actual)
    }

    @Test
    fun `divide two int numbers`() {
        val expression = "70/2"
        val expected = "35"

        val actual = Model.getCalculatedResult(expression)

        assertEquals(expected, actual)
    }

    @Test
    fun `divide two double numbers`() {
        val expression = "110.5/3"
        val expected = "36.833333"

        val actual = Model.getCalculatedResult(expression)

        assertEquals(expected, actual)
    }

    @Test
    fun `expression with all operations (int)`() {
        val expression = "1+2-3⨯4/5"
        val expected = "0.6"

        val actual = Model.getCalculatedResult(expression)

        assertEquals(expected, actual)
    }

    @Test
    fun `expression with all operations (double)`() {
        val expression = "5.4/2.3+1.2-0.7⨯2.3"
        val expected = "1.937826"

        val actual = Model.getCalculatedResult(expression)

        assertEquals(expected, actual)
    }

    @Test
    fun `empty string`() {
        val expression = ""
        val expected = "0"

        val actual = Model.getCalculatedResult(expression)

        assertEquals(expected, actual)
    }

    @Test
    fun `square root`() {
        val expression = "16"
        val expected = "4"

        val actual = Model.getSqrt(expression)

        assertEquals(expected, actual)
    }


    @Test
    fun `squaring`() {
        val expression = "5"
        val expected = "25"

        val actual = Model.getSquare(expression)

        assertEquals(expected, actual)
    }

//
//    @Test
//    fun `negative number`() {
//        val expression = "-2+1"
//        val expected = "-1"
//
//        val actual = Model.getCalculatedResult(expression)
//
//        assertEquals(expected, actual)
//    }
//
//    @Test
//    fun `divide by zero`() {
//        val expression = "1/0"
//        val expected = "0"
//
//        val actual = Model.getCalculatedResult(expression)
//
//        assertEquals(expected, actual)
//    }
}