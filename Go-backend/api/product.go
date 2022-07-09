package api

import (
	"Go-backend/db"
	"Go-backend/models"
	"fmt"
	"github.com/labstack/echo/v4"
	"net/http"
)

func GetProducts(c echo.Context) error {
	db := db.DBManager()
	products := []models.Product{}

	if err := db.Find(&products).Error; err != nil {
		fmt.Println(err)
		return c.NoContent(http.StatusNotFound)
	}

	for i := 0; i < len(products); i++ {
		db.Preload("Category").Find(&products[i])
	}

	return c.JSON(http.StatusOK, products)
}

func AddProduct(c echo.Context) error {
	db := db.DBManager()

	product := new(models.Product)
	if err := c.Bind(product); err != nil {
		fmt.Println(err)
		return c.NoContent(http.StatusNotFound)
	}

	category := new(models.Category)
	if err := db.First(&category, product.CategoryId).Error; err != nil {
		fmt.Println(err)
		return c.NoContent(http.StatusBadRequest)
	}

	result := db.Create(&product)

	if result.Error != nil {
		fmt.Println(result.Error)
		return c.NoContent(http.StatusInternalServerError)
	}

	db.Preload("Category").Find(&product)
	fmt.Println(product.ID)

	return c.JSON(http.StatusOK, product)
}

func DeteleProduct(c echo.Context) error {
	db := db.DBManager()
	pid := c.Param("pid")

	response := db.Unscoped().Delete(&models.Product{}, pid);

	if err := response.Error; err != nil {
		fmt.Println(err)
		return c.NoContent(http.StatusInternalServerError)
	}

	if response.RowsAffected == 0 {
		return c.NoContent(http.StatusNotFound)
	}

	return c.NoContent(http.StatusOK)
}