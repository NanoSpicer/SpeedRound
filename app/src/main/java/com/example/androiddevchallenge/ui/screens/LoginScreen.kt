package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MySoothePassword
import com.example.androiddevchallenge.ui.theme.MySootheTextField
import com.example.androiddevchallenge.ui.theme.PrimaryButton
import com.example.androiddevchallenge.ui.theme.TextBody1
import com.example.androiddevchallenge.ui.theme.TextH1
import com.example.androiddevchallenge.ui.theme.lgSpacing
import com.example.androiddevchallenge.ui.theme.mdSpacing
import com.example.androiddevchallenge.ui.theme.smSpacing
import com.example.androiddevchallenge.ui.theme.taupe100
import com.example.androiddevchallenge.ui.theme.taupe800
import com.example.androiddevchallenge.ui.utils.BackgroundImage


@Composable
private fun RowItem(
    modifier: Modifier = Modifier,
    vAlign: Alignment.Vertical = Alignment.Top,
    content: @Composable () -> Unit
) = Row(
    modifier =modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = vAlign
) { content() }

@Composable
fun LoginScreen()  {
    val background = if(isSystemInDarkTheme()) R.drawable.bg_dark_login else R.drawable.bg_light_login

    BackgroundImage(background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            RowItem { TextH1(text = "LOG IN") }

            RowItem(Modifier.padding(0.dp, lgSpacing, 0.dp, 0.dp)) {
                MySootheTextField(modifier = Modifier.padding(horizontal = mdSpacing), label ="Email address"){}
            }
            RowItem(Modifier.padding(0.dp, smSpacing, 0.dp, 0.dp)) {
                MySoothePassword(modifier = Modifier.padding(horizontal = mdSpacing), label ="Password"){}
            }

            RowItem(Modifier.padding(0.dp, smSpacing, 0.dp, 0.dp)) {
                PrimaryButton(modifier = Modifier.padding(horizontal = mdSpacing), text = "Log in", onClick = {})
            }

            RowItem(modifier = Modifier.height(lgSpacing), vAlign = Alignment.Bottom) {
                val color = if(isSystemInDarkTheme()) taupe100 else taupe800
                val style = MaterialTheme.typography.body1.copy(color = color)
                TextBody1(text = "Don't have an account? Sign up", style = style)
            }
        }
    }
}


@Preview("Welcome", widthDp = 360, heightDp = 640)
@Composable
fun LoginPreview() {
    LoginScreen()
}