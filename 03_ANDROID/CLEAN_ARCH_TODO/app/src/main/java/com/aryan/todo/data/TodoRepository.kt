package com.aryan.todo.data

import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    suspend fun insertTodo(todoEntity: TodoEntity)

    suspend fun deleteTodo(todoEntity: TodoEntity)

    suspend fun getTodoById(id: Int): TodoEntity?

    fun getTodos(): Flow<List<TodoEntity>>
}