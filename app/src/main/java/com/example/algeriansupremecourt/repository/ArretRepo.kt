package com.example.algeriansupremecourt.repository

import androidx.lifecycle.LiveData
import com.example.algeriansupremecourt.features.arret.ArretDao
import com.example.algeriansupremecourt.features.arret.ArretModel

class ArretRepo(private val arretDao: ArretDao) {
    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.

   suspend fun  allArrets() =  arretDao.getAllArrets()

    suspend fun insertArret(arret: ArretModel): Long {
        return arretDao.insertArret(arret)
    }

    suspend fun updateArret(arret: ArretModel) {
        arretDao.updateArret(arret)
    }

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