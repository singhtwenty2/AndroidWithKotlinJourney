package com.example.data.users

import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.eq

class MongoService(
    db: CoroutineDatabase
): StudentDataService {

    private val students =db.getCollection<Student>()

    override suspend fun getStudentDetails(usn: String): Student? {
        return students.findOne(Student::usn eq usn)
    }

    override suspend fun insertNewStudent(student: Student): Boolean {
        return students.insertOne(student).wasAcknowledged()
    }
}