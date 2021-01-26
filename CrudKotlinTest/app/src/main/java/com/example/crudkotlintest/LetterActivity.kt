package com.example.crudkotlintest

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_letter.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btnRead

class LetterActivity : AppCompatActivity() {
    lateinit var db: DataBaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letter)
        val context = this
        db = DataBaseHandler(context)

//        val letter = Letter(1, 1, "SP", "I", 2020)
//        db.insertDataLetter(letter)

        btnRead.setOnClickListener {
            Log.d("RESULT_1", "Masuk")
//            Toast.makeText(context, "Berhasil masuk", Toast.LENGTH_SHORT).show()
            val data = db.readDataLetter()
//            db.readDataLetter()
            no_surat.setText(data.no_surat.toString(), TextView.BufferType.EDITABLE)
            no_RT.setText(data.no_rt.toString(), TextView.BufferType.EDITABLE)
            kode_dokumen.setText(data.kode_surat, TextView.BufferType.EDITABLE)
            bulan_surat.setText(data.bulan_surat, TextView.BufferType.EDITABLE)
            tahun_surat.setText(data.tahun_surat.toString(), TextView.BufferType.EDITABLE)
        }

        btnEdit.setOnClickListener {
            db.updateDataLetterInt(no_surat.text.toString().toInt(),0, COL_NO_SURAT)
            db.updateDataLetterInt(no_RT.text.toString().toInt(),0, COL_NO_RT)
            db.updateDataLetterString(kode_dokumen.text.toString(),"", COL_KODE_SURAT)
            db.updateDataLetterString(bulan_surat.text.toString(),"", COL_BULAN_SURAT)
            db.updateDataLetterInt(tahun_surat.text.toString().toInt(),0, COL_TAHUN_SURAT)
        }
    }

    override fun onDestroy() {
        db.close()
        super.onDestroy()
    }
}
