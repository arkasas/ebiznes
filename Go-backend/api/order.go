package api

import (
	"Go-backend/db"
	"Go-backend/models"
	"fmt"
	"github.com/labstack/echo/v4"
	"net/http"
)

func GetOrder(c echo.Context) error {
	db := db.DBManager()
	orders := []models.Order{}
	uid := c.Param("uid")

	if err := db.Find(&orders, "user_id = ?", uid).Error; err != nil {
		panic(err)
	}

	for i := 0; i < len(orders); i++ {
		db.Preload("User").Find(&orders[i])
		db.Preload("Product").Find(&orders[i])
		db.Preload("Category").Find(&orders[i].Product)
	}

	return c.JSON(http.StatusOK, orders)
}

func AddToOrder(c echo.Context) error {
	db := db.DBManager()

	order := new(models.Order)
	if err := c.Bind(order); err != nil {
		panic(err)
		// return nil
	}

	product := new(models.Product)
	if err := db.First(&product, order.ProductId).Error; err != nil {
		return c.NoContent(http.StatusNotFound)
	}

	user := new(models.User)
	if err := db.First(&user, order.UserId).Error; err != nil {
		return c.NoContent(http.StatusNotFound)
	}

	result := db.Create(&order)
	db.Preload("User").Find(&order)
	db.Preload("Product").Find(&order)
	db.Preload("Category").Find(&order.Product)

	if result.Error != nil {
		panic(result.Error)
		// return nil
	}

	fmt.Println(order.ID)

	return c.JSON(http.StatusOK, order)
}
