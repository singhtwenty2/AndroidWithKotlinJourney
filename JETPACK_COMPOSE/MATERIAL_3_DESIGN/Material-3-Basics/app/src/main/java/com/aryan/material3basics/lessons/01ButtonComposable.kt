package com.aryan.material3basics.lessons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


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