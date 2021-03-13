package com.example.androiddevchallenge.ui.utils

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource


@Composable
fun BackgroundImage(@DrawableRes backgroundImageId: Int, content: @Composable () -> Unit) {
    val bgPainter = painterResource(id = backgroundImageId)
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(modifier = Modifier.fillMaxSize(), painter = bgPainter, contentDescription = "Background of Welcome screen")
        content()
    }
}