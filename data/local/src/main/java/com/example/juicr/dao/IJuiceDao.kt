package com.example.juicr.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.juicr.entities.JuiceEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface IJuiceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addJuice(juice: JuiceEntity): Long

    @Update
    suspend fun updateJuice(juice: JuiceEntity): Int

    @Query("DELETE FROM juices WHERE id = :id")
    suspend fun deleteJuice(id: Long): Int

    @Query("UPDATE juices SET isFavourite = NOT isFavourite WHERE id = :id")
    suspend fun toggleFavorite(id: Long): Int

    @Query("SELECT * FROM juices")
    fun getAll(): Flow<List<JuiceEntity>>

    @Query("SELECT * FROM juices WHERE id = :id LIMIT 1")
    fun getById(id: Long): Flow<JuiceEntity?>

    @Query("SELECT * FROM juices WHERE isFavourite = 1")
    fun getFavourites(): Flow<List<JuiceEntity>>

    @Query("""
        SELECT * FROM juices
        WHERE name LIKE '%' || :text || '%' COLLATE NOCASE
    """)
    fun search(text: String): Flow<List<JuiceEntity>>

    @Query("SELECT * FROM juices ORDER BY name DESC")
    fun sortByNameDesc(): Flow<List<JuiceEntity>>

    @Query("SELECT * FROM juices ORDER BY rating DESC")
    fun sortByRating(): Flow<List<JuiceEntity>>
}

