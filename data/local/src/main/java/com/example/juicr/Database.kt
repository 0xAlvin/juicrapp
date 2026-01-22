package com.example.juicr

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.juicr.dao.IJuiceDao
import com.example.juicr.dao.IPrepHistoryDao
import com.example.juicr.entities.JuiceEntity
import com.example.juicr.entities.PreparationHistoryEntity

@Database(entities = [
    JuiceEntity::class,
    PreparationHistoryEntity::class ], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun juiceDao(): IJuiceDao
    abstract fun preparationHistoryDao(): IPrepHistoryDao
}
