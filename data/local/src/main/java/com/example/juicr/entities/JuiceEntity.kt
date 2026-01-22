package com.example.juicr.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "juices")
data class JuiceEntity(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val color: String,
    val rating: Double,
    val dateAdded: Long,
    val prepTime: Long,
    val ingredients: List<IngredientEntity>,
    val timesPrepared: Int,
    val isFavourite: Boolean
)
