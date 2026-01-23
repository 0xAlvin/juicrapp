package com.example.juicr.models

data class PreparationHistory(
    val id: Long,
    val juiceId: Long,
    val timestamp: Long,
    val duration: Long
)
