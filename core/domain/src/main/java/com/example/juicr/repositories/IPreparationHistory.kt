package com.example.juicr.repositories

import com.example.juicr.models.PreparationHistory
import kotlinx.coroutines.flow.Flow

interface IPreparationHistory {
    suspend fun addHistory(prepHistory: PreparationHistory): Long

    fun getHistoryByJuiceId(id: Long): Flow<List<PreparationHistory>>
    fun getRecentHistory(limit: Int?): Flow<List<PreparationHistory>>
}
