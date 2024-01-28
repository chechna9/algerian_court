package com.example.algeriansupremecourt.database


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper



class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "arret_database"
        private const val DATABASE_VERSION = 1

        // Table name and columns
        const val TABLE_ARRETS = "arrets"
        const val COLUMN_ID = "_id"
        const val COLUMN_NUM_ARRET = "NumArret"
        const val COLUMN_CHAMBRE_ARRET = "ChambreArret"
        // Add other columns here
        const val COLUMN_FAVORITE = "favorite"
    }

    // Database creation SQL statement
    private val DATABASE_CREATE = """
        CREATE TABLE $TABLE_ARRETS (
            $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $COLUMN_NUM_ARRET TEXT NOT NULL,
            $COLUMN_CHAMBRE_ARRET TEXT NOT NULL,
            -- Add other columns here
            $COLUMN_FAVORITE INTEGER DEFAULT 0
        );
    """.trimIndent()

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(DATABASE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_ARRETS")
        onCreate(db)
    }
}
