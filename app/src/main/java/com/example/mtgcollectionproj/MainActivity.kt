package com.example.mtgcollectionproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mtgcollectionproj.ui.theme.MtgCollectionProjTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MtgCollectionProjTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BackgroundImage(
                        name = "Hey!",
                        message = "This is you collection.",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, message: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
    ) {
        Text(
            text = "$name",
            color = androidx.compose.ui.graphics.Color.White,
            fontSize = 40.sp,
            lineHeight = 40.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "$message",
            color = androidx.compose.ui.graphics.Color.White,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(8.dp)
                .align(alignment = androidx.compose.ui.Alignment.Start)
        )
    }
}

@Composable
fun BackgroundImage(name: String, message: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.black_background)
    val imageModifier = Modifier
        .border(BorderStroke(1.dp, Color.Black))
        .background(Color.Black)
    Box(Modifier.fillMaxSize().background(Color.Black)) {
        //This image is doing nothing, but in the future it will.
        Image(
            painter = image,
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
            modifier = imageModifier
        )
        Greeting(
            name = name,
            message = message,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "My Preview")
@Composable
fun GreetingPreview() {
    MtgCollectionProjTheme {
        BackgroundImage("Hey!", "This is your collection!!!")
    }
}