package com.bin.windowsmanagerdemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.bin.windowsmanagerdemo.ui.components.SinglePaneArticle
import com.bin.windowsmanagerdemo.ui.components.ThreePaneArticle
import com.bin.windowsmanagerdemo.ui.components.TwoPaneArticle
import com.bin.windowsmanagerdemo.ui.components.rememberWindowSizeClass
import com.bin.windowsmanagerdemo.ui.utills.WindowWidthSizeClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val windowSizeClass = rememberWindowSizeClass()

            MyApp(windowSizeClass)
        }
    }
}

@Composable
fun MyApp(windowWidthSizeClass: WindowWidthSizeClass) {

    MaterialTheme {
        when (windowWidthSizeClass) {
            WindowWidthSizeClass.Compact -> SinglePaneArticle()
            WindowWidthSizeClass.Medium -> TwoPaneArticle()
            WindowWidthSizeClass.Expanded,
            WindowWidthSizeClass.Large,
            WindowWidthSizeClass.ExtraLarge -> ThreePaneArticle()
        }
    }
}