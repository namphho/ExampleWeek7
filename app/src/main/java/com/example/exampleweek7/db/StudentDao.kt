package com.example.exampleweek7.db

import androidx.room.*

/**
 * Created by nampham on 5/17/21.
 */
@Dao
interface StudentDao {
    @Query("SELECT * FROM students ORDER BY name ASC")
    suspend fun getStudents(): List<Student>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)

    @Query("DELETE FROM students")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(student: Student)

    @Update
    suspend fun update(student: Student)
}