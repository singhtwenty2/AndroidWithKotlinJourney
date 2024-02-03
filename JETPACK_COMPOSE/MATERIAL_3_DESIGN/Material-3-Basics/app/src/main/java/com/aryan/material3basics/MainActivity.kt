package com.aryan.material3basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aryan.material3basics.ui.theme.Material3BasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3BasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
//                        ButtonComposable()
                        TextFieldComposable()
                    }
                }
            }
        }
    }
}
// LESSON 1 BUTTONS : 5 types
@Composable
fun ButtonComposable(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Filled Button Most Prominent in the UI.
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Filled Button")
        }
        Spacer(modifier = Modifier.height(20.dp))
        //Elevated Button Have Elevation and we can use it when we want to give show less prominent button
        ElevatedButton(
            onClick = { /*TODO*/ },
        ) {
            Icon(
                imageVector = Icons.Outlined.Add,
                contentDescription = null,
                modifier = Modifier.size(18.dp) // M-3 GUIDELINE...
            )
            Spacer(modifier = Modifier.width(8.dp)) // M-3 GUIDELINE...
            Text(text = "Elevated Button")
        }
        Spacer(modifier = Modifier.height(20.dp))
        // For less prominent uses
        FilledTonalButton(onClick = { /*TODO*/ }) {
            Text(text = "Filled Tonal Button")
        }
        Spacer(modifier = Modifier.height(20.dp))
        // Outlined Button : For less prominent uses
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Outlined Button")
        }
        Spacer(modifier = Modifier.height(20.dp))
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Learn More")
        }
    }
}

// LESSON 2 TEXT-FIELDS : 2 types
@Composable
fun TextFieldComposable(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Do not create same state for different TF
        var textState1 by remember {
            mutableStateOf("")
        }
        var textState2 by remember {
            mutableStateOf("")
        }
        TextField(
            value = textState1,
            onValueChange = { textState1 = it },
            enabled = true, // By default enabled
            label = { // Acts like Hint
                Text(text = "Enter your weight")
            },
            textStyle = TextStyle(
                textAlign = TextAlign.Right
            ),
            placeholder = { // It doesn't loose focus unlike label(it should be short and crisp)
                Text(text = "Weight")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
            },
            suffix = {
                Text(text = "Kg")
            },
            supportingText = { // Mostly used for Errors
                Text(text = "*required")
            },
            // Used for pass filling
//            visualTransformation = PasswordVisualTransformation()
            // Input Type
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    println("Hello Word!")
                }
            ),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            value = textState2,
            onValueChange = { textState2 = it },
            enabled = true, // By default enabled
            label = { // Acts like Hint
                Text(text = "Enter your weight")
            },
            textStyle = TextStyle(
                textAlign = TextAlign.Right
            ),
            placeholder = { // It doesn't loose focus unlike label(it should be short and crisp)
                Text(text = "Weight")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
            },
            suffix = {
                Text(text = "Kg")
            },
            supportingText = { // Mostly used for Errors
                Text(text = "*required")
            },
            // Used for pass filling
//            visualTransformation = PasswordVisualTransformation()
            // Input Type
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    println("Hello Word!")
                }
            ),
            singleLine = true
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    Material3BasicsTheme {
        ButtonComposable()
    }
}