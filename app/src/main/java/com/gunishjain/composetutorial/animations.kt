package com.gunishjain.composetutorial

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun animatedBox(){

    var boxSize by remember {
        mutableStateOf(200.dp)
    }

    val size by animateDpAsState (
        targetValue = boxSize,
        tween(
            durationMillis = 1000,
            delayMillis = 2000,
            easing = FastOutLinearInEasing
        )
    )

    val infiniteTransition = rememberInfiniteTransition()
    val newColor by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(modifier = Modifier
        .size(size)
        .background(newColor),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            boxSize+=20.dp
        }) {
            Text(text = "Increase Size")
        }
    }
}