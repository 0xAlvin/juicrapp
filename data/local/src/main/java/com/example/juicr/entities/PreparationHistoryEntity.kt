package com.example.juicr.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "preparation_history")
data class PreparationHistoryEntity(
    @PrimaryKey val id: Long,
    val juiceId: Long,
    val timestamp: Long,
    val duration: Long
)
