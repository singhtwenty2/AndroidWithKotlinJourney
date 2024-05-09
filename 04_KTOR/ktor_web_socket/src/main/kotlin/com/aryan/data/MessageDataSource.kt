package com.aryan.data

import com.aryan.data.model.Message

interface MessageDataSource {
    suspend fun getAllMessages(): List<Message>

    suspend fun insertNewMessage(message: Message)
}