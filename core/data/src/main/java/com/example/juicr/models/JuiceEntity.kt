import com.example.juicr.models.IngredientEntity

data class JuiceEntity(
    val id: String,
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