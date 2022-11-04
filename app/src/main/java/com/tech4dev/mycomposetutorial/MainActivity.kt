package com.tech4dev.mycomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    MessageCard("Android")
        }
    }
}



@Composable
fun MessageCard(name : String){
    Text(text = "hello $name")
}

@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard(name = "Android")
}