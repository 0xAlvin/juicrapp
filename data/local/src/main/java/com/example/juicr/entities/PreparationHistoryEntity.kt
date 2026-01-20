package com.example.juicr.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PreparationHistoryEntity(
    @PrimaryKey val id: Long,
    val juiceId: Long,
    val timestamp: Long,
    val duration: Long
)
