package com.gunishjain.composetutorial

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color= MaterialTheme.colors.background) {
                animatedBox()
            }

        }
    }
}


@Composable
fun Greeting(){
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center){
        Box(modifier = Modifier
            .background(Color.Blue)
            .width(100.dp)
            .height(100.dp)
            .verticalScroll(rememberScrollState())
        ) {
            SuperScriptText("Hi","Gunish Jain")
        }
    }
}

@Composable
fun SuperScriptText(
    normalText: String,
    superText: String
){
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            )
        ) {
            append(normalText)
        }
        withStyle(
            style = SpanStyle(
                fontSize = MaterialTheme.typography.overline.fontSize,
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Superscript
            ) ){
                append(superText)
            }
    })
}





data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {

    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_smile),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column (modifier = Modifier
            .background(Color.Gray)
            .fillMaxSize(0.2f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center

        ){
            Text(text = msg.author)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }

    }
}


/*
Note: In Column the main axis is vertical so we use arrangement for main axis
and cross axis in column is horizontal so we use Alignment.
For Main Axis = Use Arrangement
For Cross Axis = Use Alignment
 */

@Preview
@Composable
fun DefaultPreview() {
    Greeting()
}
