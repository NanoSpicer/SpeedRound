package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.PrimaryButton
import com.example.androiddevchallenge.ui.theme.SecondaryButton
import com.example.androiddevchallenge.ui.theme.lgSpacing
import com.example.androiddevchallenge.ui.theme.mdSpacing
import com.example.androiddevchallenge.ui.theme.smSpacing
import com.example.androiddevchallenge.ui.utils.BackgroundImage

@Composable
fun WelcomeScreen(nextScreen: () -> Unit = {})  {
    val logo = if(isSystemInDarkTheme()) R.drawable.ic_dark_logo else R.drawable.ic_light_logo
    val background = if(isSystemInDarkTheme()) R.drawable.bg_dark_welcome else R.drawable.bg_light_welcome
    val logoPainter = painterResource(id = logo)

    @Composable fun RowItem(modifier: Modifier = Modifier, content: @Composable () -> Unit) = Row(modifier =modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) {
        content()
    }

    BackgroundImage(background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            RowItem {
                Image(painter = logoPainter, contentDescription = "App's logo")
            }
            RowItem(Modifier.padding(0.dp, lgSpacing, 0.dp, 0.dp)) {
                PrimaryButton(modifier = Modifier.padding(horizontal = mdSpacing), text = "Sign up", onClick = {  })
            }
            RowItem(Modifier.padding(0.dp, smSpacing, 0.dp, 0.dp)) {
                SecondaryButton(modifier = Modifier.padding(horizontal = mdSpacing), text = "Log in", onClick = nextScreen)
            }
        }
    }
}


@Preview("Welcome", widthDp = 360, heightDp = 640)
@Composable
fun WelcomePreview() {
    WelcomeScreen()
}