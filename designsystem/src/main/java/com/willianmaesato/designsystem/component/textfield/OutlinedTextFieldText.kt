package com.willianmaesato.designsystem.component.textfield

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun OutlinedTextFieldText(
    valueCallBack: (String) -> Unit,
    isSingleLine: Boolean = true,
    label: String = "Nome",
    placeholder: String = "Coloque seu Nome",
) {
    val textState = remember { mutableStateOf("") }

    OutlinedTextField(
        value = textState.value,
        onValueChange = { newText ->
            textState.value = newText
        },
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
        singleLine = isSingleLine,
    )
}