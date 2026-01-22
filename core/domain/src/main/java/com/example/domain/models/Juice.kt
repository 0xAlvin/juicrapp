data class Juice(
    val id: String,
    val name: String,
    val description: String,
    val color: String,
    val rating: Double,
    val dateAdded: Long,
    val prepTime: Long,
    val ingredients: List<Ingredient>,
    val timesPrepared: Int,
    val isFavourite: Boolean
)
