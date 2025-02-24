package com.github.shishircipher.nowinandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.border
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.github.shishircipher.nowinandroid.ui.theme.NowinandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message("Android", "Jetpack Compose"))
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

data class Message(val author :  String, val body : String)
@Composable
fun MessageCard(msg: Message) {

    Row(modifier = Modifier.padding(all = 9.dp))  {
        Image (
            painter = painterResource(R.drawable.profile_picture) ,
            contentDescription = "Contact Profile Picture ",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
    }
    Column {
        Text(text = msg.author,
            color = MaterialTheme.colorScheme.secondary
        )
        // Add a vertical space between the author and message texts
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = msg.body)
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewMesageCard() {
    MessageCard (
        msg = Message("lexi", "Hey, take  look at JetCompose , it's a great!")
    )
}