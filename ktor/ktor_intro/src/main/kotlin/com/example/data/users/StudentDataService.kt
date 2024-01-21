package com.example.data.users

interface StudentDataService {

    suspend fun getStudentDetails(usn: String): Student?

    suspend fun insertNewStudent(student: Student): Boolean
}