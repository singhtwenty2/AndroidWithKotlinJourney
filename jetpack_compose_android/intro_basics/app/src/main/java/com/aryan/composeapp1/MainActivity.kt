package com.aryan.composeapp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoadUi()
        }
    }
}

/**
 * NOTES :
 * (1) MAIN AXIS & Cross Axis = The axis in which the new items will get placed like for
 * Row() { } New items will be placed in X-Axis where as the opposite to that
 * axis will be the Cross Axis.
 * (2) Alignment & Arrangement : Alignment will align the composable along the Main Axis while
 * Arrangement will arrange the composable in Cross Axis.
 * (3) Modifiers : They provide extra property property to composable like we call change the
 * size, we can make them clickable, scrollable and much more.
 * (4) In Composable we do not have margins what we have is Alternative to that may be by using
 * two approach first : We can wrap the particular composable with a container and
 * then apply padding to it (OR) second : We can simply use Spacer() { } both the approach
 * will have the same effect as margin.
 */

@Composable
fun LoadUi() {
    Column(
        modifier = Modifier
            .background(Color.Green)
            .padding(16.dp)
            .border(2.dp, Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) { //Like Vertical Linear Layout from XML
        Text(text = "Hello")
        Text(text = "World")

        Row { //Like Horizontal Linear Layout from XML
            Text(text = "Hello")
            Spacer( // Works as Margin.
                modifier = Modifier
                    .height(20.dp)
                    .clickable {
                        // Code
                    }
            )
            Text(text = "Again")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
        LoadUi()
}