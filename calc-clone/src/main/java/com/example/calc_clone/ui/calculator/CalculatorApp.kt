package com.example.calc_clone.ui.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.calc_clone.ui.calculator.components.MainContent
import com.example.calc_clone.ui.calculator.components.Panel
import com.example.calc_clone.ui.theme.CalculatorTheme

@Composable
fun CalculatorApp(
    viewModel: CalculatorViewModel
) {
    val inputState = viewModel.inputText.value
    val outputState = viewModel.outputText.value

    CalculatorTheme {
        CalculatorScreen(
            inputText = inputState.text,
            outputText = outputState.text,
            onEvent = { viewModel.onEvent(it) }
        )
    }
}

@Composable
fun CalculatorScreen(
    inputText: String,
    outputText: String,
    onEvent: (CalculatorEvent) -> Unit
) {
    BoxWithConstraints {
        val boxHeight = this.maxHeight
        val boxWidth = this.maxWidth

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            MainContent(
                inputText = inputText,
                outputText = outputText,
                height = boxHeight * 0.4f
            )
            Panel(
                height = boxHeight * 0.6f,
                width = boxWidth,
                onEvent = onEvent
            )
        }
    }
}
