package com.example.learn_roomdatabase.fargments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.learn_roomdatabase.R
import com.example.learn_roomdatabase.room.Student
import com.example.learn_roomdatabase.room.StudentDao
import com.example.learn_roomdatabase.room.StudentRepository
import com.example.learn_roomdatabase.room.StudentRoomDatabase
import kotlinx.android.synthetic.main.fragment_student_profile.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class StudentProfileFragment : Fragment() {

    private var studentRepository: StudentRepository? = null
    private var studentRoomDatabase: StudentRoomDatabase? = null
    private var studentDao: StudentDao? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDatabasePart()

        btnSaveData.setOnClickListener {
            var canISaveData = true
            when {
                etName.text?.isEmpty() == true -> {
                    tiName.error = getString(R.string.enter_name)
                    canISaveData = false
                }
                etStudentAge.text?.isEmpty() == true -> {
                    tiAge.error = getString(R.string.enter_age)
                    canISaveData = false
                }
                etPlace.text?.isEmpty() == true -> {
                    tiPlace.error = getString(R.string.enter_place)
                    canISaveData = false
                }
            }

            if (canISaveData) {
                val student = Student()
                student.studentName = etName.text.toString()
                student.studentAge = etStudentAge.text.toString().toInt()
                student.studentPlace = etPlace.text.toString()
                GlobalScope.launch {
                    studentRepository?.insertStudentRecord(student)
                }
                etName.setText("")
                etStudentAge.setText("")
                etPlace.setText("")
            }
        }

        btnGetStudentsList.setOnClickListener {

            GlobalScope.launch {
                studentRepository?.selectStudentList()
            }
        }
    }


    private fun initDatabasePart() {
        studentRoomDatabase = context?.let { StudentRoomDatabase.getDatabase(it) }
        studentDao = studentRoomDatabase?.studentDao()
        studentRepository = studentDao?.let { StudentRepository(it) }
    }
}
