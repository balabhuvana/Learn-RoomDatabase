package com.example.learn_roomdatabase.room

import android.util.Log

class StudentRepository(private var studentDao: StudentDao) {

    fun insertStudentRecord(student: Student) {
        studentDao.insertStudent(student)
    }

    fun selectStudentList() {
        val studentList = studentDao.getStudentRecords()
        for (student in studentList) {
            Log.i("ID :", "" + student.studentRollNo)
            Log.i("Name : ", "" + student.studentName)
            Log.i("Age : ", "" + student.studentAge)
            Log.i("Place : ", "" + student.studentPlace)
        }
    }

    fun selectSpecificStudent(rollNo: Int) {
        val student: Student? = studentDao.getSpecificStudentRecord(rollNo)
        student?.apply {
            Log.i("ID :", "" + student.studentRollNo)
            Log.i("Name : ", "" + student.studentName)
            Log.i("Age : ", "" + student.studentAge)
            Log.i("Place : ", "" + student.studentPlace)
        }
    }

    fun deleteSpecificStudent(rollNo: Int) {
        val student: Student? = studentDao.getSpecificStudentRecord(rollNo)
        student.let {
            student?.let { it1 -> studentDao.deleteSpecificRecord(it1) }
        }
    }
}