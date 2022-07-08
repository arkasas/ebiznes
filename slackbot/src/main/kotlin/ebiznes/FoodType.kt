package ebiznes

class FoodType (
    val id: Int,
    val type: String,
) {
    override fun toString(): String {
        return "Food [id: ${this.id}, type: ${this.type}]"
    }
}