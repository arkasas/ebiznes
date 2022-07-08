package ebiznes

class Food(
    val id: Int,
    val type: String,
    val name: String,
) {
    override fun toString(): String {
        return "Dish [id: ${this.id}, type: ${this.type}, name: ${this.name}]"
    }

}