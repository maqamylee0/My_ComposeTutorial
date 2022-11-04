package com.tech4dev.mycomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import java.nio.file.Files.size

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    MessageCard(Message("emily","Welcome to my gallery"))
        }
    }
}


data class Message(val author :String,val body:String)

@Composable
fun MessageCard(msg : Message ) {
    Row(modifier = Modifier.padding(all=8.dp)) {
        Image(painter = painterResource(R.drawable.emily ),
            contentDescription = "Profile pic for emily",
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape))
        Spacer(modifier = Modifier.width(width = 8.dp))
        Column {
            Text(text = msg.author)
            Spacer(modifier = Modifier.height(height = 8.dp))

            Text(text = msg.body )
        } 
    }
    


}

@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard(msg = Message("Emily","Welcome to my gallery"))
}