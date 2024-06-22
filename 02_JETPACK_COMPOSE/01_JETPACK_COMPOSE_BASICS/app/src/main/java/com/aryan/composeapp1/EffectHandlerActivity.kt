package com.aryan.composeapp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aryan.composeapp1.ui.theme.ComposeApp1Theme
    private var i = 0
class EffectHandlerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var text by remember {
                mutableStateOf("")
            }
            Button(onClick = { text += "#" }) {
                i++// Network call : Then in this case it will make the n/w call everytime during Recomposition which is not good
                Text(text = text)
            }
        }
    }
}

/**
 * FOR UNDERSTANDING EFFECT HANDLERS...
 * setContent {
 *             var text by remember {
 *                 mutableStateOf("")
 *             }
 *             Button(onClick = { text += "#" }) {
 *                 i++// Network call : Then in this case it will make the n/w call everytime during Recomposition which is not good
 *                 Text(text = text)
 *             }
 *         }
 */
