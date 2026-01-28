package com.example.juicr

import com.example.juicr.dao.IPrepHistoryDao
import com.example.juicr.mappers.toDomain
import com.example.juicr.mappers.toEntity
import com.example.juicr.models.PreparationHistory
import com.example.juicr.repositories.IPreparationHistory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PreparationHistoryRepositoryImpl @Inject constructor(
    private val prepHistoryDao: IPrepHistoryDao
): IPreparationHistory {
    override suspend fun addHistory(prepHistory: PreparationHistory) : Long{
        return prepHistoryDao.addHistory(prepHistory.toEntity())
    }

    override fun getHistoryByJuiceId(id: Long): Flow<List<PreparationHistory>> {
        return prepHistoryDao.getHistoryByJuiceId(id).map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override fun getRecentHistory(limit: Int?): Flow<List<PreparationHistory>> {
        return prepHistoryDao.getRecentHistory(limit).map { entities ->
            entities.map { it -> it.toDomain() }
        }
    }

}