package com.example.calculatorjetpackcompose

import androidx.compose.ui.graphics.Color


data class CalcButton(
    val text: String,
    val textColor: Color,
    val backgroundColor: Color,
    val onClick: () -> Unit
)
