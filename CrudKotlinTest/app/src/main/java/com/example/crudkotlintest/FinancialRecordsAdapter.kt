package com.example.crudkotlintest

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_phone_contact.view.*
import kotlinx.android.synthetic.main.financial_records_field.view.*

class FinancialRecordsAdapter : RecyclerView.Adapter<FinancialRecordsAdapter.ViewHolder>() {
    private var itemList : MutableList<FinancialRecords> = ArrayList()
    var context: Context? = null

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemCatatanKeuangan = itemView.findViewById<LinearLayout>(R.id.item_catatan_keuangan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.financial_records_field, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        draw(holder, itemList[position])
    }

    private fun draw(holder: ViewHolder, financialRecords: FinancialRecords) {
        holder.itemCatatanKeuangan.item_catatan_edit_text.setText(financialRecords.item_catatan)
        holder.itemCatatanKeuangan.item_harga_edit_text.setText(financialRecords.item_harga.toString())
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun getItemList(): MutableList<FinancialRecords> {
        return itemList
    }

    public fun setItemList(itemListPar: MutableList<FinancialRecords>) {
        itemList = itemListPar
        notifyDataSetChanged()
    }

}