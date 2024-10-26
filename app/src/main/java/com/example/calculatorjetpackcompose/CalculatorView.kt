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
                        text = viewModel.number.toString(),
                        color = TextColor,
                        fontSize = 42.sp
                    )
                }
            }

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
                        text = "7",
                        textColor = TextColor,
                        backgroundColor = Orange,
                    ) {
                        viewModel.addDigit("7")
                    },
                    CalcButton(
                        text = "8",
                        textColor = TextColor,
                        backgroundColor = Orange,
                    ) {
                        viewModel.addDigit("8")
                    },
                    CalcButton(
                        text = "9",
                        textColor = TextColor,
                        backgroundColor = Orange,
                    ) {
                        viewModel.addDigit("9")
                    },
                    CalcButton(
                        text = "⨯",
                        textColor = TextColor,
                        backgroundColor = Orange,
                    ) {
                        viewModel.addOperation("⨯")
                    },

                    )
                ButtonsRow(buttons)
            }

            item {
                val buttons = listOf(
                    CalcButton(
                        text = "4",
                        textColor = TextColor,
                        backgroundColor = Orange,
                    ) {
                        viewModel.addDigit("4")
                    },
                    CalcButton(
                        text = "5",
                        textColor = TextColor,
                        backgroundColor = Orange,
                    ) {
                        viewModel.addDigit("5")
                    },
                    CalcButton(
                        text = "6",
                        textColor = TextColor,
                        backgroundColor = Orange,
                    ) {
                        viewModel.addDigit("6")
                    },
                    CalcButton(
                        text = "-",
                        textColor = TextColor,
                        backgroundColor = Orange,
                    ) {
                        viewModel.addOperation("-")
                    },

                    )
                ButtonsRow(buttons)
            }

            item {
                val buttons = listOf(
                    CalcButton(
                        text = "1",
                        textColor = TextColor,
                        backgroundColor = Orange,
                    ) {
                        viewModel.addDigit("1")
                    },
                    CalcButton(
                        text = "2",
                        textColor = TextColor,
                        backgroundColor = Orange,
                    ) {
                        viewModel.addDigit("2")
                    },
                    CalcButton(
                        text = "3",
                        textColor = TextColor,
                        backgroundColor = Orange,
                    ) {
                        viewModel.addDigit("3")
                    },
                    CalcButton(
                        text = "+",
                        textColor = TextColor,
                        backgroundColor = Orange,
                    ) {
                        viewModel.addOperation("+")
                    },

                )
                ButtonsRow(buttons)
            }

            item {
                val buttons = listOf(
                    CalcButton(
                        text = "±",
                        textColor = TextColor,
                        backgroundColor = Orange,
                    ) {
                        viewModel.changeSign()
                    },
                    CalcButton(
                        text = "0",
                        textColor = TextColor,
                        backgroundColor = Orange,
                    ) {
                        viewModel.addDigit("0")
                    },
                    CalcButton(
                        text = ".",
                        textColor = TextColor,
                        backgroundColor = Orange,
                    ) {
                        viewModel.addPoint()
                    },
                    CalcButton(
                        text = "=",
                        textColor = TextColor,
                        backgroundColor = Orange,
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
        modifier = Modifier.clip(RoundedCornerShape(3)),
        border = BorderStroke(1.dp, Black),
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