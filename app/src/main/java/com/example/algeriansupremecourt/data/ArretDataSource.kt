package com.example.algeriansupremecourt.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor

import com.example.algeriansupremecourt.database.DatabaseHelper

class ArretDataSource(context: Context) {

    private val dbHelper: DatabaseHelper = DatabaseHelper(context)
    private val database = dbHelper.writableDatabase

//    fun open() {
//        database.openOrCreateDatabase(DATABASE_NAME, null)
//    }
//
//    fun close() {
//        dbHelper.close()
//    }
//
//    fun addArret(arret: ArretData) {
//        val values = ContentValues().apply {
//            put(DatabaseHelper.COLUMN_NUM_ARRET, arret.NumArret)
//            put(DatabaseHelper.COLUMN_CHAMBRE_ARRET, arret.ChambreArret)
//            // Add other columns here
//            put(DatabaseHelper.COLUMN_FAVORITE, arret.favorite)
//        }
//
//        database.insert(DatabaseHelper.TABLE_ARRETS, null, values)
//    }
//
//    fun getAllArrets(): List<ArretData> {
//        val arrets = mutableListOf<ArretData>()
//        val cursor: Cursor = database.query(DatabaseHelper.TABLE_ARRETS, null, null, null, null, null, null)
//
//        with(cursor) {
//            while (moveToNext()) {
//                val arret = ArretData(
//                    getString(getColumnIndexOrThrow(DatabaseHelper.COLUMN_NUM_ARRET)),
//                    getString(getColumnIndexOrThrow(DatabaseHelper.COLUMN_CHAMBRE_ARRET)),
//                    // Extract other columns here
//                    getBoolean(getColumnIndexOrThrow(DatabaseHelper.COLUMN_FAVORITE))
//                )
//                arrets.add(arret)
//            }
//        }
//
//        cursor.close()
//        return arrets
//    }

    // Implement other CRUD operations as needed
}
