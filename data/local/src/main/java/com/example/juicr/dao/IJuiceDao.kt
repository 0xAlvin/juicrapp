package com.example.juicr.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.juicr.entities.JuiceEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IJuiceDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addJuice(juice: JuiceEntity)

    @Update
    suspend fun updateJuice(juice: JuiceEntity): Int

    @Delete
    suspend fun deleteJuice(juice: JuiceEntity): Int

    @Query("SELECT * FROM juices")
    suspend fun getAll(): Flow<List<JuiceEntity>>

    @Query("SELECT * FROM juices WHERE id = :id LIMIT 1")
    suspend fun getById(id: Long): JuiceEntity

    @Query("SELECT * FROM juices WHERE isFavourite = TRUE")
    suspend fun getFavourites(): Flow<List<JuiceEntity>>

    @Query("SELECT * FROM juices WHERE name LIKE :text")
    suspend fun search(text: String): Flow<List<JuiceEntity>>

    @Query("SELECT * FROM juices ORDER BY name DESC")
    suspend fun sortByRating(): Flow<List<JuiceEntity>>
}
