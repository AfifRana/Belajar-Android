package com.example.crudkotlintest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

//import com.example.crudkotlintest.User

class MainActivity : AppCompatActivity() {
    lateinit var db: DataBaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "KotlinApp"
        val context = this
        db = DataBaseHandler(context)
        btnInsert.setOnClickListener {
            if (editTextName.text.toString().isNotEmpty() &&
                editTextAge.text.toString().isNotEmpty()
            ) {
                val user = User(editTextName.text.toString(), editTextAge.text.toString().toInt())
                db.insertData(user)
                clearField()
                val data = db.readData()
                tvResult.append(
                    (data[data.size-1].id).toString() + " " + data[data.size-1].name + " " + data[data.size-1].age + "\n"
                )
            }
            else {
                Toast.makeText(context, "Please Fill All Data's", Toast.LENGTH_SHORT).show()
            }
        }
        btnRead.setOnClickListener {
            val data = db.readData()
            tvResult.text = ""
            for (i in 0 until data.size) {
                tvResult.append(
                    data[i].id.toString() + " " + data[i].name + " " + data[i].age + "\n"
                )
            }
        }
        btnDelete.setOnClickListener {
            db.deleteData()
        }
        btnSearch.setOnClickListener{
            db.updateData(editTextSearch.text.toString())
        }
        btnToCamera.setOnClickListener {
            val intent = Intent(this,CameraActivity::class.java)
            startActivity(intent)
        }
        btnToPhoneContact.setOnClickListener {
//            val intent = Intent(this, LetterActivity::class.java)
            val intent = Intent(this, PhoneContactActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        db.close()
        super.onDestroy()
    }
    private fun clearField() {
        editTextName.text.clear()
        editTextAge.text.clear()
    }
}