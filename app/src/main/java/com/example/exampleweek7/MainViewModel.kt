package com.example.exampleweek7

import androidx.lifecycle.*
import com.example.exampleweek7.db.Student
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

/**
 * Created by nampham on 5/17/21.
 */
class MainViewModel(val studentRepo: StudentRepository) : ViewModel(){
    private var _students : MutableLiveData<List<Student>> = MutableLiveData()
    val students : LiveData<List<Student>>
        get() = _students

    fun getAllStudent() {
        viewModelScope.launch {
            val result = studentRepo.getAllStudents()
            _students.postValue(result)
        }
    }

    fun insert(student: Student) = viewModelScope.launch{
        studentRepo.insert(student)
        val result = studentRepo.getAllStudents()
        _students.postValue(result)
    }
}


class MainViewModelFactory(val repository: StudentRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("unknown view model")
    }

}