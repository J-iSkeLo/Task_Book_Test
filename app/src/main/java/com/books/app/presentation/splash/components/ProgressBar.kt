package com.books.app.presentation.splash.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap

@Composable
fun ProgressBar(
    modifier: Modifier,
    animatedProgress : Animatable<Float, AnimationVector1D>
) = Canvas(
    modifier = modifier
) {

    // Background indicator
    drawLine(
        color = Color(0x33FFFFFF),
        cap = StrokeCap.Round,
        strokeWidth = size.height,
        start = Offset(x = 0f, y = 0f),
        end = Offset(x = size.width, y = 0f)
    )

    val progress = (animatedProgress.value / 100) * size.width
    // Foreground indicator
    drawLine(
        color = Color(0xFFFFFFFF),
        cap = StrokeCap.Round,
        strokeWidth = size.height,
        start = Offset(x = 0f, y = 0f),
        end = Offset(x = progress, y = 0f)
    )
}