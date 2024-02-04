package com.aryan.instaui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aryan.instaui.ui.theme.InstaUiTheme
import com.aryan.instaui.ui.theme.ProfileComposable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileComposable()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InstaUiTheme {
        ProfileComposable()
    }
}