package com.example.juicr.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.juicr.converters.DateConverter
import com.example.juicr.converters.IngredientsConverter
import com.example.juicr.dao.IJuiceDao
import com.example.juicr.dao.IPrepHistoryDao
import com.example.juicr.entities.JuiceEntity
import com.example.juicr.entities.PreparationHistoryEntity

@Database(entities = [
    JuiceEntity::class,
    PreparationHistoryEntity::class ], version = 1)
@TypeConverters(
    IngredientsConverter::class,
    DateConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun juiceDao(): IJuiceDao
    abstract fun preparationHistoryDao(): IPrepHistoryDao
}
