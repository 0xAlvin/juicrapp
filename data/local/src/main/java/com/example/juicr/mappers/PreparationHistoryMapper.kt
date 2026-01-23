package com.example.juicr.mappers

import com.example.juicr.entities.PreparationHistoryEntity
import com.example.juicr.models.PreparationHistory

fun PreparationHistoryEntity.toDomain(): PreparationHistory {
    return PreparationHistory(
        id = id,
        juiceId = juiceId,
        timestamp = timestamp,
        duration = duration
    )
}

fun PreparationHistory.toEntity(): PreparationHistoryEntity {
    return PreparationHistoryEntity(
        id = id,
        juiceId = juiceId,
        timestamp = timestamp,
        duration = duration
    )
}
