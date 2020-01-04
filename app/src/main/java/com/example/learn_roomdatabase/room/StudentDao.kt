package com.example.learn_roomdatabase.room

import androidx.room.*

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertStudent(student: Student)

    @Query("SELECT * from student_table")
    fun getStudentRecords(): List<Student>

    @Query("SELECT * from student_table where roll_no = :rollNo LIMIT 1")
    fun getSpecificStudentRecord(rollNo: Int): Student

    @Delete
    fun deleteSpecificRecord(student: Student)

}