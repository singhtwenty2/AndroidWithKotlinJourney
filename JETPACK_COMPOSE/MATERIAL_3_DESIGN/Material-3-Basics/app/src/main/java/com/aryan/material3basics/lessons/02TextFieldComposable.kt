package com.aryan.material3basics.lessons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

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