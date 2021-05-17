package com.example.exampleweek7

import androidx.annotation.WorkerThread
import com.example.exampleweek7.db.Student
import com.example.exampleweek7.db.StudentDao

/**
 * Created by nampham on 5/17/21.
 */
class StudentRepository (private val studentDao: StudentDao) {

    // Room executes all queries on a separate thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getAllStudents() : List<Student> {
        return studentDao.getStudents()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(student: Student){
        studentDao.insert(student)
    }
}