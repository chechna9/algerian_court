package com.example.algeriansupremecourt.features.arret

import android.app.Application
import com.example.algeriansupremecourt.database.ArretDatabase
import com.example.algeriansupremecourt.repository.ArretRepo

class ArretApplication : Application() {
    private val db by lazy{ArretDatabase.getDatabase(this)}
     val repository by lazy {ArretRepo(db.arretDao()) }

}
