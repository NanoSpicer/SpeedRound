package com.example.androiddevchallenge.ui.utils

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource


@Composable
fun BackgroundImage(@DrawableRes backgroundImageId: Int, modifier: Modifier = Modifier,content: @Composable () -> Unit) {
    val bgPainter = painterResource(id = backgroundImageId)
    Box(
        modifier = modifier.fillMaxSize().background(MaterialTheme.colors.background)
    ) {
        Image(modifier = modifier.fillMaxSize(), painter = bgPainter, contentDescription = "Background of Welcome screen", contentScale = ContentScale.FillBounds)
        content()
    }
}