package com.example.juicr.converters

import androidx.room.TypeConverter

class IngredientsConverter {

   @TypeConverter
   fun fromList(value: List<String>): String {
       return value.joinToString(separator = "|")
   }

   @TypeConverter
   fun toList(value: String): List<String> {
       return if (value.isBlank()) emptyList()
       else value.split("|")
   }
}
