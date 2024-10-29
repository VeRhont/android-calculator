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
fun Calculator(
    viewModel: CalculatorViewModel,
    buttonsData: ButtonsData,
    modifier: Modifier = Modifier
) {

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
                color = TextColor,
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

            Divider()

            val buttons = buttonsData.getButtonsData()

            for (i in 0..buttons.size - 1 step 4) {
                ButtonsRow(
                    listOf(
                        buttons[i],
                        buttons[i + 1],
                        buttons[i + 2],
                        buttons[i + 3]
                    )
                )
            }
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