package com.example.crudkotlintest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_phone_contact.*

// Test jadi Financial Records
class PhoneContactActivity : AppCompatActivity() {
    private var parentLinearLayout: LinearLayout? = null
    lateinit var db: DataBaseHandler
    var adapter = FinancialRecordsAdapter()
    var list: MutableList<FinancialRecords> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_contact)
        title = "KotlinApp"
        parentLinearLayout = findViewById(R.id.parent_linear_layout)
        initData()
    }

    fun onDelete(view: View) {
        parentLinearLayout!!.removeView(view.parent as View)
    }

    fun onAddField(view: View) {
        val inflater =
            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView: View = inflater.inflate(R.layout.financial_records_field, null)
        parentLinearLayout!!.addView(rowView, parentLinearLayout!!.childCount-1)
    }

    fun onSave(view: View) {
//        var parent = view.parent

        var item_catatan = parentLinearLayout!!.getChildAt(0)
        var item_harga = parentLinearLayout!!.getChildAt(1)
        Log.d("Info", parentLinearLayout!!.childCount.toString())
        Log.d("Info", item_catatan.id.toString())

//        db.insertDataFinancialRecords(FinancialRecords(
//            item_catatan.text.toString(), item_harga.text.toString().toInt()))
    }

    fun initData() {
        val context = this
        db = DataBaseHandler(context)
        list = db.readDataFinancialRecords()
        if (list.size == 0) {
            var financialRecords = FinancialRecords("Nasi Padang", 10000)
        }

        adapter.context = this
        adapter.setItemList(list)

        item_activity_contact_phone.adapter = adapter
        item_activity_contact_phone.layoutManager = object : LinearLayoutManager (
            this, LinearLayoutManager.VERTICAL, false ) {
            override fun canScrollHorizontally(): Boolean {
                return false
            }
        }

//        val inflater =
//            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val rowView: View = inflater.inflate(R.layout.financial_records_field, null)
//        parentLinearLayout!!.addView(rowView, parentLinearLayout!!.childCount - 1)
    }
}