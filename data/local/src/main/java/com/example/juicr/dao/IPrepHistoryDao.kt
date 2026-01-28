package com.example.juicr.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.juicr.entities.PreparationHistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IPrepHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHistory(history : PreparationHistoryEntity): Long

    @Query("""
        SELECT * FROM preparation_history
        WHERE juiceId = :juiceId
        ORDER BY timestamp DESC
    """)
    fun getHistoryByJuiceId(juiceId: Long): Flow<List<PreparationHistoryEntity>>

    @Query("""
        SELECT * FROM preparation_history
        ORDER BY timestamp DESC
        LIMIT :limit
    """)
    fun getRecentHistory(limit: Int? = 20): Flow<List<PreparationHistoryEntity>>
}
