package com.aryan.todo.screen.todo_lists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aryan.todo.data.TodoEntity
import com.aryan.todo.data.TodoRepository
import com.aryan.todo.util.Routes
import com.aryan.todo.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {

    val todos = todoRepository.getTodos()

    private val _uiEvent = Channel<UiEvent>() // Mutable Version

    val uiEvent = _uiEvent.receiveAsFlow() // Immutable Version For Ui Layer

    private var deletedTodo: TodoEntity? = null

    fun onEvent(event: TodoListEvents) {
        when(event) {
            is TodoListEvents.OnTodoClick -> {
                sendAsyncUiEvents(UiEvent.Navigate(Routes.ADD_EDIT_TODO + "?todoId=${event.todoEntity.id}"))
            }
            is TodoListEvents.OnAddTodoClick -> {
                sendAsyncUiEvents(UiEvent.Navigate(Routes.ADD_EDIT_TODO))
            }
            is TodoListEvents.DeleteTodo -> {
                viewModelScope.launch {
                    deletedTodo = event.todo
                    todoRepository.deleteTodo(event.todo)
                    sendAsyncUiEvents(UiEvent.ShowSnackBar(
                        "Todo Deleted",
                        "Undo"
                    ))
                }
            }
            is TodoListEvents.OnDoneChange -> {
                viewModelScope.launch {
                    todoRepository.insertTodo(
                        event.todo.copy(
                            isDone = event.isDone
                        )
                    )
                }
            }
            is TodoListEvents.OnUndoDeleteClick -> {
                deletedTodo?.let {todo ->
                    viewModelScope.launch {
                        todoRepository.insertTodo(todo)
                    }
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