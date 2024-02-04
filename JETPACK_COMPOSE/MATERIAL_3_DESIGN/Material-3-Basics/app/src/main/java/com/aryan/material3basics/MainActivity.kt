package com.aryan.material3basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.aryan.material3basics.lessons.CheckBoxComposable
import com.aryan.material3basics.lessons.SwitchComposable
import com.aryan.material3basics.lessons.ToolBarComposable
import com.aryan.material3basics.ui.theme.Material3BasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.
        setDecorFitsSystemWindows(window,false)

        setContent {
            Material3BasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),

                    ) {
                        ToolBarComposable()
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    Material3BasicsTheme {

    }
}