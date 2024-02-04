package com.aryan.material3basics.lessons

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp

// Lesson 04 : Top App Bar (Toolbar)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolBarComposable() {
    val scrollBehaviourState = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehaviourState.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(text = "My Screen")
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = null
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = null
                        )
                    }
                },
                scrollBehavior = scrollBehaviourState
            )
        }
    ) {value ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(value)
        ) {
            items(100) {
            Text(
                text = "Item-$it",
                Modifier.padding(16.dp)
            )
            }
        }
    }
}