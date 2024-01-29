package com.example.algeriansupremecourt.repository

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.algeriansupremecourt.features.arret.ArretDao
import com.example.algeriansupremecourt.features.arret.ArretModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ArretRepo(private val arretDao: ArretDao) {
    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.

    suspend fun insertArrets( arrets:List<ArretModel>) {
            arretDao.insertArrets(arrets)
    }

   suspend fun  allArrets() =  arretDao.getAllArrets()


    suspend fun markAsFavorite(id: Long) {
        arretDao.markAsFavorite(id)
    }

    suspend fun unmarkAsFavorite(id: Long) {
        arretDao.unmarkAsFavorite(id)
    }

    suspend fun getArretById(id: Long): LiveData<ArretModel?> {
        return arretDao.getArretById(id)
    }

    suspend fun getFavoriteArrets(): LiveData<List<ArretModel>> {
        return arretDao.getFavoriteArrets()
    }
}