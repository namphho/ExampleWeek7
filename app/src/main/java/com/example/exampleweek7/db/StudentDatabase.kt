package com.example.exampleweek7.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by nampham on 5/17/21.
 */
@Database(entities = arrayOf(Student::class), version = 1, exportSchema = false)
public abstract class StudentDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao

    companion object {

        @Volatile
        private var INSTANCE: StudentDatabase? = null

        fun getDatabase(ctx: Context): StudentDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    ctx.applicationContext,
                    StudentDatabase::class.java, "student_database"
                ).build()
                INSTANCE  = instance
                instance
            }
        }
    }
}