package com.example.learn_roomdatabase.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learn_roomdatabase.R
import com.example.learn_roomdatabase.fargments.StudentProfileFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.studentFrameLayout,
                StudentProfileFragment()
            ).commit()
    }
}
