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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.androiddevchallenge.ui.screens.LoginScreen
import com.example.androiddevchallenge.ui.screens.MainScreen
import com.example.androiddevchallenge.ui.screens.WelcomeScreen
import com.example.androiddevchallenge.ui.theme.MySootheTheme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

class MainActivity : AppCompatActivity() {
    enum class Screen {
        Welcome, Login, Main
    }

    private val favoriteLabels = Pair(
        listOf(
            // Not found on the webpage!!! Reusing 13
            R.drawable._13 to "Short mantras",
            R.drawable._9 to "Stress and anxiety",
            R.drawable._13 to "Overwhelmed",
        ),
        listOf(
            R.drawable._12 to "Nature\nmeditations",
            R.drawable._14 to "Self-massage",
            R.drawable._8 to "Nightly wind\ndown",
        )
    )

    private val bodyLabels = listOf(
        R.drawable._2 to "Inversions",
        R.drawable._1 to "Quick yoga",
        R.drawable._3 to "Stretching",
        R.drawable._6 to "Tabata",
        R.drawable._16 to "HIIT",
        R.drawable._7 to "Pre-natal yoga"
    )

    private val mindLabels = listOf(
        R.drawable._5 to "Meditate",
        R.drawable._17 to "With kids",
        R.drawable._10 to "Aromatherapy",
        R.drawable._15 to "On the go",
        R.drawable._4 to "With pets",
        R.drawable._11 to "High stress"
    )

    private val screens = Screen.values()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            var currentScreen by rememberSaveable { mutableStateOf(0) }
            MySootheTheme {
                ProvideWindowInsets {
                    when (screens[currentScreen]) {
                        Screen.Welcome -> WelcomeScreen { currentScreen = 1 }
                        Screen.Login -> LoginScreen { currentScreen = 2 }
                        Screen.Main -> MainScreen(favoriteLabels, bodyLabels, mindLabels)
                    }
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MySootheTheme {
        WelcomeScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MySootheTheme(darkTheme = true) {
        WelcomeScreen()
    }
}
