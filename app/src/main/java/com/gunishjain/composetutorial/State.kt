package com.gunishjain.composetutorial

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random



@Composable
fun MultiBox(){
    Column(modifier = Modifier.fillMaxSize()) {
        val color = remember { mutableStateOf(Color.Yellow) }
        ColorBox(
            Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            color.value=it
        }
        Box(modifier = Modifier
            .background(color.value)
            .weight(1f)
            .fillMaxSize())

    }
}

@Composable
fun ColorBox(modifier: Modifier=Modifier,
             updateColor: (Color)->Unit
){
    Box(modifier= modifier
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat()
                )
            )
        }
        .alpha(1f))
}


@Composable
fun scrollColumn(){
    LazyRow{
        items(5000){
            Text(
                text = "Item $it",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 13.dp, vertical = 5.dp)
            )
        }
    }
}


