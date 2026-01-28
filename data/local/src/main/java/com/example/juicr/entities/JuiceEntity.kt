package com.example.juicr.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "juices")
@Serializable
data class JuiceEntity(
    @PrimaryKey val id: Long,
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
