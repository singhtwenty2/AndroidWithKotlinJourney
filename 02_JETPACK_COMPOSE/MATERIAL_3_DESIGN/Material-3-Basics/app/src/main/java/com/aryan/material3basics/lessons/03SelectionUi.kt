package com.aryan.material3basics.lessons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

// Lesson 3: Selection UI Components (Checkboxes, Switches, Radio Buttons)

data class ToggleableInfo(
    val isChecked: Boolean,
    val text: String
)


@Composable
fun CheckBoxComposable() {
    val checkBoxState = remember {
        mutableStateListOf(
            ToggleableInfo(
                isChecked = false,
                text = "Photos"
            ),
            ToggleableInfo(
                isChecked = false,
                text = "Videos"
            ),
            ToggleableInfo(
                isChecked = false,
                text = "Audios"
            )
        )
    }

    // For the Parent Tri-State CheckBox
    var triState by remember {
        mutableStateOf(ToggleableState.Indeterminate)
    }
    val toggleTriState = {
        triState = when (triState) {
            ToggleableState.Indeterminate -> ToggleableState.On
            ToggleableState.On -> ToggleableState.Off
            else -> ToggleableState.On
        }
        checkBoxState.indices.forEach { index ->
            checkBoxState[index] = checkBoxState[index].copy(
                isChecked = triState == ToggleableState.On
            )
        }
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable {
                toggleTriState()
            }
            .padding(end = 16.dp)
    ) {
        TriStateCheckbox(
            state = triState,
            onClick = toggleTriState
        )
        Text(text = "File Type")
    }

    checkBoxState.forEachIndexed { index, info ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 32.dp)
                .clickable {
                    checkBoxState[index] = info.copy(
                        isChecked = !info.isChecked
                    )
                }
                .padding(end = 16.dp)
        ) {
            Checkbox(
                checked = info.isChecked,
                onCheckedChange = { newIsCheakedState ->
                    checkBoxState[index] = info.copy(
                        isChecked = newIsCheakedState
                    )
                }
            )
            Text(text = info.text)
        }
    }
}

@Composable
fun SwitchComposable() {
    var switchState by remember {
        mutableStateOf(
            ToggleableInfo(
                isChecked = false,
                text = "Dark Mode"
            )
        )
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = switchState.text)
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = switchState.isChecked,
            onCheckedChange = { newIsCheakedState ->
                switchState = switchState.copy(
                    isChecked = newIsCheakedState
                )
            },
            thumbContent = {
                Icon(
                    imageVector = if(switchState.isChecked){
                        Icons.Default.Check
                    } else {
                        Icons.Default.Close
                    },
                    contentDescription = null
                )
            }
        )
    }
}