package com.example.juicr.mappers

import com.example.juicr.models.Ingredient
import com.example.juicr.models.Juice
import com.example.juicr.entities.IngredientEntity
import com.example.juicr.entities.JuiceEntity

fun JuiceEntity.toDomain(): Juice {
    return Juice(
        id = id,
        name = name,
        description = description,
        color = color,
        rating = rating,
        dateAdded = dateAdded,
        prepTime = prepTime,
        ingredients = ingredients.map { (id,name, category, imgRes) ->
            Ingredient(id,name,category,imgRes) },
        timesPrepared = timesPrepared,
        isFavourite = isFavourite
    )
}

fun Juice.toEntity(): JuiceEntity {
    return JuiceEntity(
        id = id,
        name = name,
        description = description,
        color = color,
        rating = rating,
        dateAdded = dateAdded,
        prepTime = prepTime,
        ingredients = ingredients.map { (id, name, category, imgRes) ->
            IngredientEntity(id,name, category, imgRes)
        },
        timesPrepared = timesPrepared,
        isFavourite = isFavourite
    )
}