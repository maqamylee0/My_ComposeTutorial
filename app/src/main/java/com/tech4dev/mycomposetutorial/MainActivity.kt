package com.tech4dev.mycomposetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.tech4dev.mycomposetutorial.ui.theme.MyComposeTutorialTheme

import java.nio.file.Files.size

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTutorialTheme() {
                androidx.compose.material.Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(Message("emily","Welcome to my gallery"))
                }

            }
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
            .clip(CircleShape)
            .border(
                1.5.dp, MaterialTheme.colors.secondary, CircleShape
            ))
        Spacer(modifier = Modifier.width(width = 8.dp))
        var isExpanded by remember{ mutableStateOf(false) }
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(text = msg.author,
            color = MaterialTheme.colors.secondaryVariant,
            style = MaterialTheme.typography.subtitle2)
            Spacer(modifier = Modifier.height(height = 8.dp))
            androidx.compose.material.Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(text = msg.body,
                    modifier = Modifier.padding(all = 2.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2)
            }

        } 
    }
    


}
@Composable
fun Conversation(messages : List<Message>){
    LazyColumn{
        messages.map { item { MessageCard(msg = it)} }

    }

}
@Preview
@Composable
fun PreviewConversation() {
    MyComposeTutorialTheme {
        Conversation(SampleData.conversationSample)
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard(){
    MyComposeTutorialTheme {
        androidx.compose.material.Surface {
            MessageCard(msg = Message("Emily","Welcome to my gallery"))


        }

    }
}