package com.example.calculatorjetpackcompose

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.calculatorjetpackcompose.ui.theme.*


@Composable
fun Calculator(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        DarkGray,
                        Black
                    )
                )
            )
            .padding(32.dp)

    ) {

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {

            item {

                val buttons = listOf(
                    CalcButton(
                        text = "1",
                        textColor = White,
                        backgroundColor = Orange,
                    ) {
                        print("OK")
                    },
                    CalcButton(
                        text = "2",
                        textColor = White,
                        backgroundColor = Orange,
                    ) {
                        print("OK")
                    },
                    CalcButton(
                        text = "3",
                        textColor = White,
                        backgroundColor = Orange,
                    ) {
                        print("OK")
                    },
                    CalcButton(
                        text = "4",
                        textColor = White,
                        backgroundColor = Orange,
                    ) {
                        print("OK")
                    },
                )

                ButtonsRow(buttons)


            }
        }
    }
}

@Composable
fun ButtonsRow(buttons: List<CalcButton>, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0..buttons.size - 1) {
            val button = buttons[i]

            RoundButton(
                button.text,
                button.textColor,
                button.backgroundColor,
                button.onClick
            )
        }
    }
}


@Composable
fun RoundButton(
    text: String,
    textColor: Color,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier.clip(CircleShape),
        border = BorderStroke(1.dp, White),
        colors = ButtonDefaults.buttonColors(containerColor = Orange),
        onClick = onClick
    ) {

        Text(
            text = text,
            color = textColor
        )

    }
}