package com.example.algeriansupremecourt.features.arret

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ArretDao {
    @Query("DELETE FROM arrets")
     fun deleteAllArrets()
    @Insert
     fun insertArrets(arrets: List<ArretModel>)

    @Query("SELECT * FROM arrets WHERE id = :id")
     fun getArretById(id: Long): LiveData<ArretModel?>

    @Query("SELECT * FROM arrets")
     fun getAllArrets(): LiveData<List<ArretModel>>


    // Mark an arret as favorite
    @Query("UPDATE arrets SET isFavorite = 1 WHERE id = :id")
     fun markAsFavorite(id: Long)

    // Unmark an arret as favorite
    @Query("UPDATE arrets SET isFavorite = 0 WHERE id = :id")
     fun unmarkAsFavorite(id: Long)


    // Example query to get favorite arrets
    @Query("SELECT * FROM arrets WHERE isFavorite = 1")
     fun getFavoriteArrets(): LiveData<List<ArretModel>>
}
