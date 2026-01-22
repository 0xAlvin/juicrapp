package com.example.juicr.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class IngredientEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val category: String,
    val imgRes: String
)
