package com.example.juicr.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "preparation_history")
@Serializable
data class PreparationHistoryEntity(
    @PrimaryKey val id: Long,
    val juiceId: Long,
    val timestamp: Long,
    val duration: Long
)
