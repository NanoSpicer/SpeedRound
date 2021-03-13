package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R


@Composable
private fun MySootheButton(modifier: Modifier = Modifier, text: String, colors: ButtonColors, onClick: () -> Unit) {
    Button(
        modifier = modifier
            .height(72.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = colors,
        onClick = onClick
    ) {
        TextButton(text = text)
    }
}

@Composable
fun PrimaryButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    val colors = ButtonDefaults.buttonColors(
        backgroundColor = MaterialTheme.colors.primary
    )
    MySootheButton(modifier, text, colors, onClick)
}

@Composable
fun SecondaryButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    val colors = ButtonDefaults.buttonColors(
        backgroundColor = MaterialTheme.colors.secondary
    )
    MySootheButton(modifier, text, colors, onClick)
}


@Composable
private fun MySootheTextField(
    modifier: Modifier = Modifier,
    label: String,
    defaultText: String = "",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    onTextChange: (String) -> Unit,
    leadingIcon: @Composable () -> Unit = {},
) {
    var textVal by remember { mutableStateOf(defaultText) }
    val colors = if(isSystemInDarkTheme()) {
        TextFieldDefaults.textFieldColors()
    }else {
        TextFieldDefaults.textFieldColors(
            textColor = gray800,
            backgroundColor = white800
        )
    }
    TextField(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        leadingIcon = leadingIcon,
        textStyle = MaterialTheme.typography.body1,
        placeholder = { TextBody1(text = label) },
        value = textVal, onValueChange = { textVal = it; onTextChange(it) },
        colors = colors,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions
    )
}

@Composable
fun MySootheEmail(modifier: Modifier = Modifier, label: String, defaultText: String = "", onTextChange: (String) -> Unit) {
    MySootheTextField(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        label = label,
        onTextChange = { onTextChange(it) }
    )
}

@Composable
fun MySootheSearch(modifier: Modifier = Modifier, label: String, defaultText: String = "", onTextChange: (String) -> Unit) {
    val search = painterResource(id = R.drawable.ic_search)
    MySootheTextField(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        label = label,
        leadingIcon = { Icon(search, "Search icon", modifier = Modifier.size(18.dp)) },
        onTextChange = { onTextChange(it) }
    )
}

@Composable
fun MySoothePassword(modifier: Modifier = Modifier, label: String, defaultText: String = "", onTextChange: (String) -> Unit) {
    MySootheTextField(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        label = label,
        onTextChange = { onTextChange(it) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}