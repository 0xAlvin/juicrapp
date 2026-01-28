package com.example.juicr.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class IngredientEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val category: String,
    val imgRes: String
)
