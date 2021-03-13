package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp




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



@Preview
@Composable fun MySootheButton_Preview() {
    MySootheTheme {
        PrimaryButton(text = "Hello World", onClick = {})
    }

}
