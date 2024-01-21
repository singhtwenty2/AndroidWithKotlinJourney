package com.example.data.users

interface UserDataSource {
    suspend fun getUserByUsername(username: String): User?
    suspend fun insertUser(user: User): Boolean
}