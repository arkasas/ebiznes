package ebiznes

import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import com.slack.api.Slack
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.FileReader


val token = System.getenv("SLACK_TOKEN")
val slack = Slack.getInstance()

fun Routing.foodRoute() {
    post("/food_type") {
        val gson = Gson()
        val fileContent = Routing::class.java.classLoader.getResource("food_type.json").readText()
        val data: List<FoodType> = gson.fromJson(fileContent , Array<FoodType>::class.java).toList()
        call.respondText(data.toString())
    }

    post("/food") {
        val gson = Gson()
        val fileContent = Routing::class.java.classLoader.getResource("food.json").readText()
        val data: List<Food> = gson.fromJson(fileContent , Array<Food>::class.java).toList()
        call.respondText(data.toString())
    }

}
