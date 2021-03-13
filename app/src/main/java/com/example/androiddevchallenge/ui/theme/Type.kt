/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import java.util.*


val kulimParkLight = Font(R.font.kulimpark_light).toFontFamily()
val kulimParkRegular = Font(R.font.kulimpark_regular).toFontFamily()
val latoBold = Font(R.font.lato_bold).toFontFamily()
val latoRegular = Font(R.font.lato_regular).toFontFamily()
// Set of Material typography styles to start with
val typography = Typography(
    h1 = TextStyle(
        fontFamily = kulimParkLight,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        letterSpacing = 1.15.sp
    ),
    // CAPS
    h2 = TextStyle(
        fontFamily = kulimParkRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        letterSpacing = 1.15.sp,
    ),
    h3 = TextStyle(
        fontFamily = latoBold,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
    ),
    body1 = TextStyle(
        fontFamily = latoRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 1.15.sp,
    ),
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        letterSpacing = 1.15.sp,
    )
)

@Composable fun TextH1(modifier: Modifier = Modifier, text: String) = Text(modifier = modifier, text = text, style = MaterialTheme.typography.h1)
@Composable fun TextH2(modifier: Modifier = Modifier, text: String) = Text(modifier = modifier, text = text.CAPS, style = MaterialTheme.typography.h2)
@Composable fun TextH3(modifier: Modifier = Modifier, text: String) = Text(modifier = modifier, text = text, style = MaterialTheme.typography.h3)
@Composable fun TextBody1(modifier: Modifier = Modifier, text: String) = Text(modifier = modifier, text = text, style = MaterialTheme.typography.body1)
@Composable fun TextCaption(modifier: Modifier = Modifier, text: String) = Text(modifier = modifier, text = text.CAPS, style = MaterialTheme.typography.caption)
@Composable fun TextButton(modifier: Modifier = Modifier, text: String) = Text(modifier = modifier, text = text.CAPS, style = MaterialTheme.typography.button)

private val String.CAPS get() = toUpperCase(Locale.ROOT)

