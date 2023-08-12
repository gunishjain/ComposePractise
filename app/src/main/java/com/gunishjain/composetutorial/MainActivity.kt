package com.gunishjain.composetutorial

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Column(modifier = Modifier
                    .border(5.dp,Color.Magenta)
                    .padding(5.dp)
                    .border(10.dp,Color.Black)
                    .padding(5.dp)
                    .offset(30.dp,30.dp)
                    .border(5.dp,Color.Green)
                ){
                    MessageCard(Message("Gunish", "Jetpack Compose"))
                    Text(text = "hello", modifier = Modifier.clickable {
                        Toast.makeText(applicationContext,"Hello",Toast.LENGTH_SHORT).show()
                    })
                }

        }
    }
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
            .background(Color.Blue)
            .fillMaxSize(0.2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ){
            Text(text = msg.author)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }

    }
}


/*
Note: In Column the the main axis is vertical so we use arrangement for main axis
and cross axis in column is horizontal so we use Alignment.
For Main Axis = Use Arrangement
For Cross Axis = Use Alignment
 */

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(
        msg = Message("Lexi", "yo, take a look at Jetpack Compose, it's great!")
    )
}
