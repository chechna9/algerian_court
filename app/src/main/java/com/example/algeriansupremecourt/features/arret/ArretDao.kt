package com.example.algeriansupremecourt.features.arret

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ArretDao {
    @Insert
    suspend fun insertArrets(arrets: List<ArretModel>)

    @Insert
     fun insertArret(arret: ArretModel): Long

    @Update
     fun updateArret(arret: ArretModel)

    @Query("SELECT * FROM arrets WHERE id = :id")
     fun getArretById(id: Long): LiveData<ArretModel?>

    @Query("SELECT * FROM arrets")
     fun getAllArrets(): LiveData<List<ArretModel>>

    // Add other queries or operations as needed

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
