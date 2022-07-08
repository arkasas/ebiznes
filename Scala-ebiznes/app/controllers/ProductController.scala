package controllers

import model.Product
import model.NewProduct
import javax.inject._
import play.api.libs.json._
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import scala.collection.mutable

@Singleton
class ProductController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  private val products = new mutable.ListBuffer[Product]()
  products += Product(1, 10, "Pralka", 1)
  products += Product(2, 100, "Zmywarka", 1)
  products += Product(3, 200, "Suszarka", 1)
  products += Product(4, 3000, "Lodówka", 1)
  products += Product(5, 4990, "Piekarnik", 1)
  products += Product(6, 110, "Płyta grzewcza", 1)

  products += Product(6, 1110, "iPhone 5", 2)
  products += Product(7, 210, "iPhone 6", 2)
  products += Product(8, 310, "iPhone 7", 2)
  products += Product(9, 410, "iPhone 8", 2)
  products += Product(10, 810, "iPhone 9", 2)
  products += Product(11, 510, "iPhone X", 2)

  implicit val productsListJson = Json.format[Product]
  implicit val newProductListJson = Json.format[NewProduct]

  def getAll(): Action[AnyContent] = Action {
    if (products.isEmpty) NoContent else Ok(Json.toJson(products))
  }

  def getById(itemId: Long) = Action {
    val foundItem = products.find(_.id == itemId)
    foundItem match {
      case Some(item) => Ok(Json.toJson(item))
      case None => NotFound
    }
  }

  def getByCategory(categoryId: Long) = Action {
    val foundItem = products.filter(_.categoryId == categoryId)
    Ok(Json.toJson(foundItem))

  }

  def deleteById(itemId: Long) = Action {
    val foundItem = products.filterInPlace(_.id != itemId)
    Accepted
  }

  def update(itemId: Long) = Action { implicit request =>
    val content = request.body
    val jsonObject = content.asJson

    val newItem: Option[NewProduct] =
      jsonObject.flatMap(
        Json.fromJson[NewProduct](_).asOpt
      )

    val index = products.indexWhere(el => el.id == itemId)


    newItem match {
      case Some(item) =>
        var current = products(index)
        products(index) = Product(current.id, item.price, item.name, item.categoryId)
        Created(Json.toJson(products(index)))
      case None => NotFound
    }

  }

  def addNewItem() = Action { implicit request =>
    val content = request.body
    val jsonObject = content.asJson

    val todoListItem: Option[NewProduct] =
      jsonObject.flatMap(
        Json.fromJson[NewProduct](_).asOpt
      )

    todoListItem match {
      case Some(newItem) =>
        val nextId = products.map(_.id).max + 1
        val toBeAdded = Product(nextId, newItem.price, newItem.name, newItem.categoryId)
        products += toBeAdded
        Created(Json.toJson(toBeAdded))
      case None =>
        BadRequest
    }
  }

}
