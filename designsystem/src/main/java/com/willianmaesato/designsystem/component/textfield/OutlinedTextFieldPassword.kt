package com.willianmaesato.designsystem.component.textfield

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun OutlinedTextFieldPassword(
    valueCallBack: (String) -> Unit,
    isSingleLine: Boolean = true,
    label: String = "Senha",
    placeholder: String = "Coloque sua senha",
) {

    val passwordState = remember { mutableStateOf("") }
    val passwordVisibleState = remember { mutableStateOf(false) }

    OutlinedTextField(
        value = passwordState.value,
        onValueChange = { newPassword ->
            passwordState.value = newPassword
            valueCallBack(newPassword)
        },
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
        singleLine = isSingleLine,
        visualTransformation = if (passwordVisibleState.value) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisibleState.value)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            val description =
                if (passwordVisibleState.value) "Esconder senha" else "Mostrar senha"

            IconButton(onClick = { passwordVisibleState.value = !passwordVisibleState.value }) {
                Icon(imageVector = image, description)
            }
        }
    )
}