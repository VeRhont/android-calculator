package com.example.calculatorjetpackcompose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorjetpackcompose.ui.theme.*


@Composable
fun Calculator(viewModel: CalculatorViewModel, modifier: Modifier = Modifier) {

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

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Text(
                text = viewModel.lastExpression,
                color = LightGray,
                fontSize = 20.sp,
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 15.dp),
                overflow = TextOverflow.Clip,
                softWrap = false
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .padding(30.dp),
                contentAlignment = Alignment.BottomEnd
            ) {

                Text(
                    text = viewModel.expression,
                    color = TextColor,
                    fontSize = 42.sp,
                    lineHeight = 42.sp,
                    maxLines = 3
                )
            }


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


            Divider()


            var buttons = listOf(
                operationButtons.getValue("C"),
                operationButtons.getValue("√x"),
                operationButtons.getValue("x²"),
                operationButtons.getValue("⌫")
            )
            ButtonsRow(buttons)


            buttons = listOf(
                digitButtons[7],
                digitButtons[8],
                digitButtons[9],
                operationButtons.getValue("⨯")
            )
            ButtonsRow(buttons)



            buttons = listOf(
                digitButtons[4],
                digitButtons[5],
                digitButtons[6],
                operationButtons.getValue("-")
            )
            ButtonsRow(buttons)



            buttons = listOf(
                digitButtons[1],
                digitButtons[2],
                digitButtons[3],
                operationButtons.getValue("+")
            )
            ButtonsRow(buttons)



            buttons = listOf(
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
            ButtonsRow(buttons)

        }
    }
}


@Composable
fun ButtonsRow(buttons: List<CalcButton>, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        for (i in 0..buttons.size - 1) {
            val button = buttons[i]

            RoundButton(
                button.text,
                button.textColor,
                button.backgroundColor,
                button.borderColor,
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
    borderColor: Color,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier.clip(RoundedCornerShape(3)),
        border = BorderStroke(1.dp, borderColor),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        onClick = onClick
    ) {

        Text(
            text = text,
            color = textColor,
            fontSize = 32.sp
        )

    }
}


@Composable
fun Divider() {
    HorizontalDivider(
        color = TextColor,
        thickness = 0.7.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
}