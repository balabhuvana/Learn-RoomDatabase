package com.example.learn_roomdatabase.fargments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.learn_roomdatabase.R
import kotlinx.android.synthetic.main.fragment_student_profile.*

/**
 * A simple [Fragment] subclass.
 */
class StudentProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


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
                proceedToSaveData()
            }
        }
    }

    private fun proceedToSaveData() {

    }
}
