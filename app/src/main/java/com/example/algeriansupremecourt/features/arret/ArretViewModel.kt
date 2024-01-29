package com.example.algeriansupremecourt.features.arret
import com.example.algeriansupremecourt.repository.ArretRepo

import androidx.lifecycle.*
import kotlinx.coroutines.launch


class ArretViewModel(private val repository: ArretRepo): ViewModel() {

    suspend fun allArrets(): LiveData<List<ArretModel>> = repository.allArrets()

    fun insertArret(arret: ArretModel) {
        viewModelScope.launch {
            repository.insertArret(arret)
        }
    }

    fun updateArret(arret: ArretModel) {
        viewModelScope.launch {
            repository.updateArret(arret)
        }
    }

    fun markAsFavorite(id: Long) {
        viewModelScope.launch {
            repository.markAsFavorite(id)
        }
    }

    fun unmarkAsFavorite(id: Long) {
        viewModelScope.launch {
            repository.unmarkAsFavorite(id)
        }
    }

    suspend fun getArretById(id: Long): LiveData<ArretModel?> {
        return repository.getArretById(id)
    }

    suspend fun getFavoriteArrets(): LiveData<List<ArretModel>> {
        return repository.getFavoriteArrets()
    }
}
