package com.aryan.todo.screen.todo_lists

import com.aryan.todo.data.TodoEntity

sealed class TodoListEvents {

    /**
     * data class -> if parameters required
     * object -> if no parameters required
      */
    data class DeleteTodo(val todo: TodoEntity): TodoListEvents()
    data class OnDoneChange(val todo: TodoEntity, val isDone: Boolean): TodoListEvents()
    object OnUndoDeleteClick: TodoListEvents()
    data class OnTodoClick(val todoEntity: TodoEntity): TodoListEvents()
    object OnAddTodoClick: TodoListEvents()
}