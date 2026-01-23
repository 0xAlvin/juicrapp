package com.example.juicr.repositories

import com.example.juicr.models.Juice
import kotlinx.coroutines.flow.Flow


interface IJuiceRepository {
    fun getAllJuices(): Flow<List<Juice>>
    fun getJuiceById(id: Long): Flow<Juice?>
    fun getFavourites(): Flow<List<Juice>>
    fun search(text: String): Flow<List<Juice>>
    fun sortByNameDesc(): Flow<List<Juice>>
    fun sortByRating(): Flow<List<Juice>>

    suspend fun addJuice(juice: Juice): Long
    suspend fun updateJuice(juice: Juice): Int
    suspend fun deleteJuice(id: Long): Int
    suspend fun toggleFavourite(id: Long): Int
}

