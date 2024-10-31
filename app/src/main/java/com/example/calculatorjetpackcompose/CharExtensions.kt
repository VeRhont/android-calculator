package com.example.calculatorjetpackcompose


fun Char.isOperation(): Boolean {
    return (this in "+⨯/-")
}