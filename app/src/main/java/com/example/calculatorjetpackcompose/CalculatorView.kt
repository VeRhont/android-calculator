package com.example.calculatorjetpackcompose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 0.dp, 0.dp, 20.dp)
                        .height(200.dp)
                        .background(Orange)
                        .padding(30.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Text(
                        text = viewModel.number,
                        color = TextColor,
                        fontSize = 42.sp
                    )
                }
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

            val operationButtons = mapOf(
                "plus" to CalcButton(
                    text = "+",
                    textColor = TextColor,
                    backgroundColor = LightGray,
                    borderColor = LightGray,

                    ) {
                    viewModel.addOperation("+")
                },
                "minus" to CalcButton(
                    text = "-",
                    textColor = TextColor,
                    backgroundColor = LightGray,
                    borderColor = LightGray,

                    ) {
                    viewModel.addOperation("-")
                },
            )


            item {
                HorizontalDivider(
                    color = LightGray,
                    thickness = 0.5.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
            }

            item {
                val buttons = listOf(
                    CalcButton(
                        text = "C",
                        textColor = TextColor,
                        backgroundColor = Orange,
                        borderColor = Orange,

                    ) {
                        viewModel.clear()
                    },
                    CalcButton(
                        text = "√x",
                        textColor = TextColor,
                        backgroundColor = Orange,
                        borderColor = Orange,

                    ) {
                        viewModel.sqrt()
                    },
                    CalcButton(
                        text = "x²",
                        textColor = TextColor,
                        backgroundColor = Orange,
                        borderColor = Orange,

                    ) {
                        viewModel.power()
                    },
                    CalcButton(
                        text = "⌫",
                        textColor = TextColor,
                        backgroundColor = Orange,
                        borderColor = Orange,

                    ) {
                        viewModel.removeLastSymbol()
                    },

                    )
                ButtonsRow(buttons)
            }


            item {
                val buttons = listOf(
                    digitButtons[7],
                    digitButtons[8],
                    digitButtons[9],
                    CalcButton(
                        text = "⨯",
                        textColor = TextColor,
                        backgroundColor = Orange,
                        borderColor = Orange,

                    ) {
                        viewModel.addOperation("⨯")
                    }
                )
                ButtonsRow(buttons)
            }

            item {
                val buttons = listOf(
                    digitButtons[4],
                    digitButtons[5],
                    digitButtons[6],
                    operationButtons.getValue("minus")
                )
                ButtonsRow(buttons)
            }

            item {
                val buttons = listOf(
                    digitButtons[1],
                    digitButtons[2],
                    digitButtons[3],
                    operationButtons.getValue("plus")
                )
                ButtonsRow(buttons)
            }

            item {
                val buttons = listOf(
                    CalcButton(
                        text = "±",
                        textColor = TextColor,
                        backgroundColor = Orange,
                        borderColor = Orange,

                    ) {
                        viewModel.changeSign()
                    },
                    digitButtons[0],
                    CalcButton(
                        text = ".",
                        textColor = TextColor,
                        backgroundColor = Orange,
                        borderColor = Orange,

                    ) {
                        viewModel.addPoint()
                    },
                    CalcButton(
                        text = "=",
                        textColor = TextColor,
                        backgroundColor = Orange,
                        borderColor = Orange,
                    ) {
                        viewModel.getResult()
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
        modifier = modifier
            .fillMaxSize()
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