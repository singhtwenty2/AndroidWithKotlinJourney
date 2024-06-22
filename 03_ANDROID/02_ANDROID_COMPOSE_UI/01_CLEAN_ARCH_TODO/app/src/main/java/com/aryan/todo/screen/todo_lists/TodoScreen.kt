package com.aryan.todo.screen.todo_lists

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aryan.todo.util.UiEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreenComposable(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: TodoListViewModel = hiltViewModel()
) {
    val todos = viewModel.todos.collectAsState(initial = emptyList())
    val scaffoldState = rememberBottomSheetScaffoldState()
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    val result = scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message, actionLabel = event.action
                    )
                    if (result == SnackbarResult.ActionPerformed) {
                        viewModel.onEvent(TodoListEvents.OnUndoDeleteClick)
                    }
                }

                is UiEvent.Navigate -> onNavigate(event)
                else -> Unit
            }
        }
    }
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            viewModel.onEvent(TodoListEvents.OnAddTodoClick)
        }) {
            Icon(
                imageVector = Icons.Default.Add, contentDescription = "Add Button"
            )
        }
    }) { value ->
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(todos.value) { todo ->
                TodoItemComposable(
                    todoEntity = todo,
                    onEvents = viewModel::onEvent, // All the events are now directly handeled by viewmodel
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            viewModel.onEvent(TodoListEvents.OnTodoClick(todo))
                        }
                        .padding(16.dp)
                )
            }
        }
    }
}