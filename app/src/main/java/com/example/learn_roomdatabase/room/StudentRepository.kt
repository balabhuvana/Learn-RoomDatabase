package com.example.learn_roomdatabase.room

import android.util.Log

class StudentRepository(private var studentDao: StudentDao) {

    fun insertStudentRecord(student: Student) {
        studentDao.insertStudent(student)
    }

    fun selectStudentList() {
        val studentList = studentDao.getStudentRecords()
        for (student in studentList) {
            Log.i("Name : ", "" + student.studentName)
            Log.i("Age : ", "" + student.studentAge)
            Log.i("Place : ", "" + student.studentPlace)
        }
    }

}