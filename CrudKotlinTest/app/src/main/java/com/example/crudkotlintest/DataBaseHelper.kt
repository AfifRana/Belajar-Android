package com.example.crudkotlintest

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import kotlin.properties.Delegates

val DATABASENAME = "MY DATABASE"

val TABLENAME = "Users"
val COL_NAME = "name"
val COL_AGE = "age"
val COL_ID = "id"

val TABLENAME_KIDS = "Kids"
val COL_KID_NAME = "kid_name"
val COL_KID_HOBBY = "kid_hobby"

val TABLENAME_HOBBY = "Hobbies"
val COL_HOBBY_NAME = "hobby_name"

val TABLENAME_SURAT = "Surat"
val COL_NO_SURAT = "nosurat"
val COL_NO_RT = "nort"
val COL_KODE_SURAT = "kodesurat"
val COL_BULAN_SURAT = "bulansurat"
val COL_TAHUN_SURAT = "tahunsurat"

val TABLENAME_CATATAN_KEUANGAN = "Catatan_Keuangan"
val COL_ITEM_CATATAN = "item_catatan"
val COL_ITEM_HARGA = "item_harga"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASENAME, null,
    1) {
//    var inserted

    override fun onCreate(db: SQLiteDatabase?) {
        var createTable = "CREATE TABLE " + TABLENAME_SURAT + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NO_SURAT + " INTEGER," + COL_NO_RT + " INTEGER," + COL_KODE_SURAT + " VARCHAR(2)," + COL_BULAN_SURAT + " VARCHAR(4)," + COL_TAHUN_SURAT + " INTEGER)"
        db?.execSQL(createTable)
        createTable = "CREATE TABLE " + TABLENAME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NAME + " VARCHAR(256)," + COL_AGE + " INTEGER)"
        db?.execSQL(createTable)
        createTable = "CREATE TABLE " + TABLENAME_HOBBY + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_HOBBY_NAME + " VARCHAR(10))"
        db?.execSQL(createTable)
        createTable = "CREATE TABLE " + TABLENAME_KIDS + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_KID_NAME + " VARCHAR(10)," + COL_KID_HOBBY + " INTEGER, FOREIGN KEY(" + COL_KID_HOBBY + ") REFERENCES " + TABLENAME_HOBBY + "(" + COL_ID + ") ON UPDATE CASCADE)"
        db?.execSQL(createTable)
        createTable = "CREATE TABLE " + TABLENAME_CATATAN_KEUANGAN + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_ITEM_CATATAN + " VARCHAR(10)," + COL_ITEM_HARGA + " INTEGER)"
        db?.execSQL(createTable)
//        val letter = Letter(1, 1, "SP", "I", 2020)
//        insertDataLetter(letter)
//        inserted = false
//        createTable = "CREATE TABLE " + TABLENAME_SURAT + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NO_SURAT + " INTEGER," + COL_NO_RT + " INTEGER," + COL_KODE_SURAT + " VARCHAR(2)," + COL_BULAN_SURAT + " VARCHAR(4)," + COL_TAHUN_SURAT + " INTEGER)"
//        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //onCreate(db);
//        val query3 = "DROP TABLE " + "${TABLENAME}"
//        val result2 = db?.execSQL(query3)
    }

    fun insertData(user: User) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        Log.d("INSERT_NAMA",user.name)
        Log.d("INSERT_UMUR",user.age.toString())
        contentValues.put(COL_NAME, user.name)
        contentValues.put(COL_AGE, user.age)
        val result = database.insert(TABLENAME, null, contentValues)
        if (result == (0).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
//            Log.d("INSERT_NAMA",user.name)
//            Log.d("INSERT_UMUR",user.age.toString())
        }
    }

    fun readData(): MutableList<User> {
        val list: MutableList<User> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLENAME"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                val user = User("Afif",0)
                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                user.name = result.getString(result.getColumnIndex(COL_NAME))
                user.age = result.getString(result.getColumnIndex(COL_AGE)).toInt()
                Log.d("READ_NAMA","Read Nama ${user.age}")
                Log.d("READ_UMUR",user.age.toString())
                list.add(user)
            }
            while (result.moveToNext())
        }
        return list
    }

    fun deleteData() {
        val query = "Delete from $TABLENAME"
        val query2 = "UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME=$TABLENAME"
        val query3 = "DROP TABLE " + "${TABLENAME}"
        val db = this.writableDatabase
//        val selection = ""
//        val selectionArgs = ""
        val result = db.delete("$TABLENAME",null,null)
//        val result2 = db?.execSQL(query3)
//        val contentValues = ContentValues()
    }

    fun updateData(item: String) {
        val contentValues = ContentValues()
        val db = this.writableDatabase
        val newAge = 1

        val values = contentValues.apply {
            put(COL_AGE,newAge)
        }

        val selection = "${COL_NAME} LIKE ?"
        val selectionArgs = arrayOf(item)

        val count = db.update(TABLENAME, values, selection, selectionArgs)
    }

    /* Letter */
    fun insertDataLetter(letter: Letter){
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_NO_SURAT, letter.no_surat)
        contentValues.put(COL_NO_RT, letter.no_rt)
        contentValues.put(COL_KODE_SURAT, letter.kode_surat)
        contentValues.put(COL_BULAN_SURAT, letter.bulan_surat)
        contentValues.put(COL_TAHUN_SURAT, letter.tahun_surat)

        val result = database.insert(TABLENAME_SURAT, null, contentValues)
        Toast.makeText(context, "Berhasil insert, yeah", Toast.LENGTH_SHORT).show()
    }

    fun readDataLetter(): Letter {
        val db = this.readableDatabase
//        val projection = arrayOf()

        val query = "SELECT * FROM $TABLENAME_SURAT"
        var result = db.rawQuery(query, null)
        if(result.count == 0) {
            val letter = Letter(1, 1, "SP", "I", 2020)
            insertDataLetter(letter)
//            inserted = true
        }

        result = db.rawQuery(query, null)
//        Log.d("RESULT", inserted.toString())
//        db.query(TABLENAME_SURAT, )
        Toast.makeText(context, "Berhasil masuk", Toast.LENGTH_SHORT).show()
//
        val letter = Letter(0, 0, "", "", 0)
        Log.d("COUNT", result.count.toString())
        if (result.moveToNext()) {
            Log.d("DATA", result.isFirst.toString())
            Log.d("NO_SURAT", result.getString(result.getColumnIndex(COL_NO_SURAT)))
            Log.d("NO_RT", result.getString(result.getColumnIndex(COL_NO_RT)))
            Log.d("KODE_SURAT", result.getString(result.getColumnIndex(COL_KODE_SURAT)))
            Log.d("BULAN_SURAT", result.getString(result.getColumnIndex(COL_BULAN_SURAT)))
            Log.d("TAHUN_SURAT", result.getString(result.getColumnIndex(COL_TAHUN_SURAT)))
            letter.no_surat = result.getString(result.getColumnIndex(COL_NO_SURAT)).toInt()
            letter.no_rt = result.getString(result.getColumnIndex(COL_NO_RT)).toInt()
            letter.kode_surat = result.getString(result.getColumnIndex(COL_KODE_SURAT))
            letter.bulan_surat = result.getString(result.getColumnIndex(COL_BULAN_SURAT))
            letter.tahun_surat = result.getString(result.getColumnIndex(COL_TAHUN_SURAT)).toInt()
        } else {
            Toast.makeText(context, "Read Data failed", Toast.LENGTH_SHORT).show()
        }
        return letter
    }

    fun updateDataLetterString(itemNew: String, itemOld: String, column: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        val values = contentValues.apply {
            put(column, itemNew) }

        val selection = "${column} LIKE ?"
        val selectionArgs = arrayOf(itemOld)

        val count = db.update(TABLENAME_SURAT, values, null, null)
        if (count == 1) {
            Toast.makeText(context, "Edit string data success", Toast.LENGTH_SHORT).show()
        }
    }

    fun updateDataLetterInt(itemNew: Int, itemOld: Int, column: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        val values = contentValues.apply {
            put(column, itemNew)
        }

        val selection = "${column} LIKE ?"
        val selectionArgs = arrayOf(itemOld.toString())

        val count = db.update(TABLENAME_SURAT, values, null, null)
        if (count == 1) {
            Toast.makeText(context, "Edit integer data success", Toast.LENGTH_SHORT).show()
        }
    }

    /* Hobbies and Kids */
    fun insertDataHobby(hobby_name: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_HOBBY_NAME, hobby_name)

        val result = db.insert(TABLENAME_HOBBY, null, contentValues)
        Log.d("HOBBY_NAME",hobby_name)
    }

    fun insertDataKid (kid_name: String, kid_hobby: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        val hobby_id = findHobbyId(kid_hobby)
        contentValues.put(COL_KID_NAME, kid_name)
        contentValues.put(COL_KID_HOBBY, hobby_id)

        val result = db.insert(TABLENAME_KIDS, null, contentValues)
        Log.d("KID_HOBBY",kid_hobby)
    }

    fun readDataHobby(): MutableList<Hobby> {
        val db = this.readableDatabase
        val list: MutableList<Hobby> = ArrayList()
        val query = "SELECT * FROM $TABLENAME_HOBBY"
        var result = db.rawQuery(query, null)
        Log.d("COUNT_HOBBY", result.count.toString())

        if (result.moveToFirst()) {
            do {
                var hobby = Hobby(0, "")
                hobby = Hobby(result.getString(result.getColumnIndex(COL_ID)).toInt(), result.getString(result.getColumnIndex(COL_HOBBY_NAME)))
                Log.d("HOBBY_ID", hobby.id.toString())
                list.add(hobby)
            } while (result.moveToNext())
        }

        return list
    }

    fun readDataKid(): MutableList<Kid> {
        val db = this.readableDatabase
        val list: MutableList<Kid> = ArrayList()
        val query = "SELECT * FROM $TABLENAME_KIDS"
        var result = db.rawQuery(query, null)

        Log.d("COUNT_KID", result.count.toString())

        if (result.moveToFirst()) {
            do {
                var kid = Kid(1, "","")
                val kid_hobby_id = result.getString(result.getColumnIndex(COL_KID_HOBBY)).toInt()
                Log.d("KID_HOBBY_ID", kid_hobby_id.toString())
                val kid_hobby = findHobbyName(kid_hobby_id)
                kid = Kid(result.getString(result.getColumnIndex(COL_ID)).toInt(), result.getString(result.getColumnIndex(COL_KID_NAME)), kid_hobby)
                list.add(kid)
            } while (result.moveToNext())
        }
        return list
    }

    fun readDataKidByHobby(kid_hobby: String): MutableList<Kid> {
        val db = this.readableDatabase
        val list: MutableList<Kid> = ArrayList()
        val hobby_id = findHobbyId(kid_hobby)
        val query = "SELECT * FROM $TABLENAME_KIDS WHERE $COL_KID_HOBBY = ?"
        val selectionArgs = arrayOf(hobby_id.toString())
        var result = db.rawQuery(query, selectionArgs)

        Log.d("COUNT_KID", result.count.toString())

        if (result.moveToFirst()) {
            do {
                var kid = Kid(1, "","")
                val kid_hobby_id = result.getString(result.getColumnIndex(COL_KID_HOBBY)).toInt()
                Log.d("KID_HOBBY_ID", kid_hobby_id.toString())
                val kid_hobby = findHobbyName(kid_hobby_id)
                kid = Kid(result.getString(result.getColumnIndex(COL_ID)).toInt(), result.getString(result.getColumnIndex(COL_KID_NAME)), kid_hobby)
                list.add(kid)
            } while (result.moveToNext())
        }

        return list
    }

    fun updateDataHobbyString(itemNew: String, itemOld: String, column: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        val values = contentValues.apply {
            put(column, itemNew)
        }

        val selection = "${column} LIKE ?"
        val selectionArgs = arrayOf(itemOld)

        val count = db.update(TABLENAME_HOBBY, values, selection, selectionArgs)
        if (count == 1) {
            Toast.makeText(context, "Edit Hobby's name data success", Toast.LENGTH_SHORT).show()
        }
    }


    fun findHobbyName(id: Int): String {
        val db = this.readableDatabase
        val query = "Select ${COL_HOBBY_NAME} from $TABLENAME_HOBBY where ${COL_ID} = ?"
        val selectionArgs = arrayOf(id.toString())

        var result = db.rawQuery(query, selectionArgs)
        Log.d("COUNT_HOBBY_NAME", result.count.toString())
        lateinit var hobby_name: String

        if (result.moveToNext()) {
            hobby_name = result.getString(result.getColumnIndex(COL_HOBBY_NAME))
            Log.d("RESULT_NAME", hobby_name)
        }

        return hobby_name
    }

    fun findHobbyId(hobby_name: String): Int {
        val db = this.readableDatabase
        val query = "Select ${COL_ID} from $TABLENAME_HOBBY where ${COL_HOBBY_NAME} = ?"
        val selectionArgs = arrayOf(hobby_name)

        val result = db.rawQuery(query, selectionArgs)
        var hobby_id: Int = 0

        if (result.moveToNext()) {
            hobby_id = result.getString(result.getColumnIndex(COL_ID)).toInt()
            Log.d("RESULT_ID", hobby_id.toString())
        }

        return hobby_id
    }

    /* FinancialRecords */
    fun insertDataFinancialRecords(financialRecords: FinancialRecords){
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_ITEM_CATATAN, financialRecords.item_catatan)
        contentValues.put(COL_ITEM_HARGA, financialRecords.item_harga)

        val result = database.insert(TABLENAME_CATATAN_KEUANGAN, null, contentValues)
//        database.close()
        Toast.makeText(context, "Berhasil insert, yeah", Toast.LENGTH_SHORT).show()
    }

    fun readDataFinancialRecords(): MutableList<FinancialRecords> {
        val db = this.readableDatabase
//        val projection = arrayOf()
        var list: MutableList<FinancialRecords> = mutableListOf()

        val query = "SELECT * FROM $TABLENAME_CATATAN_KEUANGAN"
        var result = db.rawQuery(query, null)
        if(result.count == 0) {
            var financialRecords = FinancialRecords("Nasi Goreng", 12000)
            insertDataFinancialRecords(financialRecords)
            financialRecords = FinancialRecords("Bubur Ayam", 6000)
            insertDataFinancialRecords(financialRecords)
            financialRecords = FinancialRecords("Mie Ayam", 10000)
            insertDataFinancialRecords(financialRecords)
//            inserted = true
        }

        result = db.rawQuery(query, null)
//        Log.d("RESULT", inserted.toString())
//        db.query(TABLENAME_SURAT, )
        Toast.makeText(context, "Berhasil masuk", Toast.LENGTH_SHORT).show()
//
        lateinit var financialRecords: FinancialRecords
        Log.d("COUNT", result.count.toString())
        if (result.moveToNext()) {
            do {
                financialRecords = FinancialRecords("", 0)
                Log.d("DATA", result.isFirst.toString())
                financialRecords.item_catatan = result.getString(result.getColumnIndex(COL_ITEM_CATATAN))
                financialRecords.item_harga = result.getInt(result.getColumnIndex(COL_ITEM_HARGA))
                Log.d("ITEM_CATATAN", financialRecords.item_catatan)
                Log.d("ITEM_HARGA", financialRecords.item_harga.toString())
                list.add(financialRecords)
            } while (result.moveToNext())
        } else {
            Toast.makeText(context, "Read Data failed", Toast.LENGTH_SHORT).show()
        }
//        db.close()
        return list
    }

    fun updateDataFinancialRecordsString(itemNew: String, itemOld: String, column: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        val values = contentValues.apply {
            put(column, itemNew) }

        val selection = "${column} LIKE ?"
        val selectionArgs = arrayOf(itemOld)

        val count = db.update(TABLENAME_CATATAN_KEUANGAN, values, null, null)
        if (count == 1) {
            Toast.makeText(context, "Edit string data success", Toast.LENGTH_SHORT).show()
        }
//        db.close()
    }

    fun updateDataFinancialRecordsInt(itemNew: Int, itemOld: Int, column: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        val values = contentValues.apply {
            put(column, itemNew)
        }

        val selection = "${column} LIKE ?"
        val selectionArgs = arrayOf(itemOld.toString())

        val count = db.update(TABLENAME_CATATAN_KEUANGAN, values, null, null)
        if (count == 1) {
            Toast.makeText(context, "Edit integer data success", Toast.LENGTH_SHORT).show()
        }
//        db.close()
    }
}
