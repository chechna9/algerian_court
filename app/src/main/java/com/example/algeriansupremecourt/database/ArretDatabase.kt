package com.example.algeriansupremecourt.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.algeriansupremecourt.features.arret.ArretDao
import com.example.algeriansupremecourt.features.arret.ArretModel

@Database(entities = [ArretModel::class], version = 1, exportSchema = false)
abstract class ArretDatabase : RoomDatabase() {

    abstract fun arretDao(): ArretDao

    companion object {
        @Volatile
        private var INSTANCE: ArretDatabase? = null

        fun getDatabase(context: Context): ArretDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ArretDatabase::class.java,
                    "arret_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }
}
