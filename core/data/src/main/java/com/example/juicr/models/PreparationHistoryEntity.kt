package com.example.juicr.models

data class PreparationHistoryEntity(
    val id: Long,
    val juiceId: Long,
    val timestamp: Long,
    val duration: Long
)
