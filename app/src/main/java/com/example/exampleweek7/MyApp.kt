package com.example.exampleweek7

import android.app.Application
import com.example.exampleweek7.db.StudentDatabase

/**
 * Created by nampham on 5/17/21.
 */
class MyApp : Application() {
    val database by lazy { StudentDatabase.getDatabase(this)}
    val repository by lazy { StudentRepository(database.studentDao()) }
}