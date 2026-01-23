package com.example.juicr.mappers

import com.example.juicr.models.Ingredient
import com.example.juicr.entities.IngredientEntity

fun IngredientEntity.toDomain(): Ingredient =
    Ingredient(
        id = id,
        name = name,
        category = category,
        imgRes = imgRes
    )

fun Ingredient.toEntity(): IngredientEntity =
    IngredientEntity(
        id = id,
        name = name,
        category = category,
        imgRes = imgRes
    )
