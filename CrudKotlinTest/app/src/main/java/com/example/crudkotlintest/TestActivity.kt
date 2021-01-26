package com.example.crudkotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_test.*
import java.io.File

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        btnClickMe.setOnClickListener {
            File(this.getExternalFilesDir(null), "file.txt").writeText("Test File")
        }
    }
}