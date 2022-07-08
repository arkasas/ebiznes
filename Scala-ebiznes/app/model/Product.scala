package model

case class Product(id: Long, price: Double, name: String, categoryId: Long)
case class NewProduct(price: Double, name: String, categoryId: Long)
