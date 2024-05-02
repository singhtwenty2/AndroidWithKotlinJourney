package com.aryan.todo.data

import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(
    private val dao: TodoDAO
): TodoRepository {
    override suspend fun insertTodo(todoEntity: TodoEntity) {
        dao.insertTodo(todoEntity)
    }

    override suspend fun deleteTodo(todoEntity: TodoEntity) {
        dao.deleteTodo(todoEntity)
    }

    override suspend fun getTodoById(id: Int): TodoEntity? {
        return dao.getTodoById(id)
    }

    override fun getTodos(): Flow<List<TodoEntity>> {
        return dao.getTodos()
    }
}