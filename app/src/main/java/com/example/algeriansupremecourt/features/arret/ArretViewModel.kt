package com.example.algeriansupremecourt.features.arret
import android.app.Application

import androidx.lifecycle.*
import kotlinx.coroutines.launch


class ArretViewModel(private val application: Application): AndroidViewModel(application) {
    private val arretApplication: ArretApplication
        get() = getApplication() as ArretApplication

    private val repository by lazy { arretApplication.repository }
    suspend fun allArrets(): LiveData<List<ArretModel>> = repository.allArrets()
    fun insertArretsFromJson(arrets:List<ArretModel>) =

        viewModelScope.launch {
            repository.insertArrets(arrets)
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

class ArretViewModelFactory(private val application: Application) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArretViewModel::class.java)) {
            return ArretViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}