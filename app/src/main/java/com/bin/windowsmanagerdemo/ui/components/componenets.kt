package com.bin.windowsmanagerdemo.ui.components

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.window.layout.WindowMetricsCalculator
import com.bin.windowsmanagerdemo.ui.utills.WindowWidthSizeClass

@Composable
fun rememberWindowSizeClass(): WindowWidthSizeClass {
    val context = LocalContext.current
    val windowMetricsCalculator = WindowMetricsCalculator.getOrCreate()
    val windowMetrics = windowMetricsCalculator.computeCurrentWindowMetrics(context as Activity)
    val widthDp = with(LocalDensity.current) {
        windowMetrics.bounds.width().toDp()
    }

    return when {
        widthDp < 600.dp -> WindowWidthSizeClass.Compact
        widthDp < 840.dp -> WindowWidthSizeClass.Medium
        widthDp < 1200.dp -> WindowWidthSizeClass.Expanded
        widthDp < 1600.dp -> WindowWidthSizeClass.Large     // New in 1.5 idea
        else -> WindowWidthSizeClass.ExtraLarge             // New in 1.5 idea
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SinglePaneArticle() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Jetpack WindowManager") }) }
    ) { padding ->
        Column(Modifier.padding(padding).padding(16.dp)) {
            Text("Building adaptive layouts", style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(8.dp))
            Text("On smaller screens we keep everything in a single column...")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TwoPaneArticle() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Jetpack WindowManager") }) }
    ) { padding ->
        Row(
            Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            Column(Modifier.weight(1f).padding(16.dp)) {
                Text("Main content", style = MaterialTheme.typography.headlineMedium)
                Text("On tablets we show the content on the left...")
            }
            Divider(Modifier.fillMaxHeight().width(1.dp))
            Column(Modifier.weight(1f).padding(16.dp)) {
                Text("Sidebar", style = MaterialTheme.typography.titleMedium)
                Text("Related articles, table of contents, etc.")
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThreePaneArticle() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Jetpack WindowManager") }) }
    ) { padding ->
        Row(
            Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            Column(Modifier.weight(1f).padding(16.dp)) {
                Text("Main content", style = MaterialTheme.typography.headlineMedium)
                Text("On tablets we show the content on the left...")
            }
            VerticalDivider(Modifier.fillMaxHeight().width(1.dp))
            Column(Modifier.weight(1f).padding(16.dp)) {
                Text("Sidebar", style = MaterialTheme.typography.titleMedium)
                Text("Related articles, table of contents, etc.")
            }
            VerticalDivider(Modifier.fillMaxHeight().width(1.dp))
            Column(Modifier.weight(1f).padding(16.dp)) {
                Text("Third Column Bar", style = MaterialTheme.typography.titleMedium)
                Text("Third column bar for large and extra large screens")
            }
        }
    }
}