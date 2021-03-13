package com.example.androiddevchallenge.ui.utils

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource


@Composable
fun BackgroundLayer(modifier: Modifier = Modifier, @DrawableRes backgroundImageId: Int? = null, content: @Composable () -> Unit) {
    val bgPainter = backgroundImageId?.let { painterResource(id = it) }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        if(bgPainter != null) {
            Image(modifier = modifier.fillMaxSize(), painter = bgPainter, contentDescription = "Background of Welcome screen", contentScale = ContentScale.FillBounds)
        }
        content()
    }
}