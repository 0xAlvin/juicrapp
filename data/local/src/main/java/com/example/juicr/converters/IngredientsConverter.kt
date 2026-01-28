package com.example.juicr.converters

import androidx.room.TypeConverter
import com.example.juicr.entities.IngredientEntity
import kotlinx.serialization.json.Json

class IngredientsConverter {
    private val json = Json { ignoreUnknownKeys = true }

   @TypeConverter
   fun fromList(value: List<IngredientEntity>): String {
       return json.encodeToString(value)
   }

   @TypeConverter
   fun toList(value: String): List<IngredientEntity> {
       return try {
           json.decodeFromString(value)
       }catch (e: Exception){
           emptyList()
       }
   }
}
