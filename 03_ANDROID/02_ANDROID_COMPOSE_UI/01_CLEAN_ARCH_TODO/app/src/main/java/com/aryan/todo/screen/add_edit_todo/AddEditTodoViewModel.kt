package com.aryan.todo.screen.add_edit_todo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aryan.todo.data.TodoEntity
import com.aryan.todo.data.TodoRepository
import com.aryan.todo.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditTodoViewModel @Inject constructor(
    private val repository: TodoRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var todo by mutableStateOf<TodoEntity?>(null)
        private set

    var title by mutableStateOf("")
        private set

    var description by mutableStateOf("")
        private set

    private val _uiEvent = Channel<UiEvent>() // Mutable Version

    val uiEvent = _uiEvent.receiveAsFlow() // Immutable Version For Ui Layer

    init {
        val todoId = savedStateHandle.get<Int>("todoId")!!
        // -1 : We load an existing todo
        if (todoId != -1) {
            viewModelScope.launch {
                repository.getTodoById(todoId)?.let {
                    title = it.title
                    description = it.description ?: ""
                    this@AddEditTodoViewModel.todo = it
                }
            }
        }
    }

    fun onEvent(event: AddEditTodoEvent) {
        when (event) {
            is AddEditTodoEvent.OnTitleChange -> {
                title = event.title
            }

            is AddEditTodoEvent.OnDescriptionChange -> {
                description = event.description
            }

            is AddEditTodoEvent.OnSaveTodoClick -> {
                viewModelScope.launch {
                    if (title.isBlank()) {
                        sendAsyncUiEvents(
                            UiEvent.ShowSnackBar(
                                message = "The title can't be empty"
                            )
                        )
                        return@launch
                    }
                    repository.insertTodo(
                        TodoEntity(
                            title = title,
                            description = description,
                            isDone = todo?.isDone ?: false,
                            id = todo?.id
                        )
                    )
                    sendAsyncUiEvents(UiEvent.PopBackStack)
                }
            }
        }
    }

    private fun sendAsyncUiEvents(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}