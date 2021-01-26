package com.example.crudkotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hobby_and_kid.*

class HobbyAndKidActivity : AppCompatActivity() {
    val db = DataBaseHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobby_and_kid)

        btnInsertKid.setOnClickListener() {
            db.insertDataHobby("Sepak Bola")
//            db.insertDataKid("Afif", "Sepak Bola")
            db.insertDataKid("Basyar Rana", "Sepak Pojok")
        }

        btnReadKid.setOnClickListener() {
            val data2 = db.readDataHobby()
            val data = db.readDataKid()
//            val data = db.readDataKidByHobby("Sepak Pojok")

            tvResultHobby.setText("${data2[0].hobby_name}\n")
            for (i in 1 until data.size) {
                tvResultHobby.append(
                    "${data2[i].hobby_name}\n"
                )
            }

            tvResultKid.setText("${data[0].kid_name} -> ${data[0].kid_hobby}\n")
            for (i in 1 until data.size) {
                tvResultKid.append(
                    "${data[i].kid_name} -> ${data[i].kid_hobby}\n"
                )
            }
//            tvResultKid.setText("${data2.hobby_name}")
        }

        btnEdit.setOnClickListener {
            db.updateDataHobbyString("Sepak Pojok", "Sepak Bola", COL_HOBBY_NAME)
        }
    }
}