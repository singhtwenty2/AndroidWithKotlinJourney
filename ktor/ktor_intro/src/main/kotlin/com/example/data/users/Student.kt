package com.example.data.users

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Student(
    val name: String,
    val usn: String,
    val dob: String,
    val phoneNumber: Long,
    @BsonId val id: ObjectId = ObjectId()
)
