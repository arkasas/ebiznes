package api

import (
	"Go-backend/db"
	"Go-backend/models"
	"fmt"
	"github.com/labstack/echo/v4"
	"net/http"
)

func GetCategories(c echo.Context) error {
	db := db.DBManager()
	categories := []models.Category{}

	if err := db.Find(&categories).Error; err != nil {
		fmt.Println(err)
		return c.NoContent(http.StatusInternalServerError)
	}

	return c.JSON(http.StatusOK, categories)
}

func AddCategory(c echo.Context) error {
	db := db.DBManager()

	category := new(models.Category)
	if err := c.Bind(category); err != nil {
		fmt.Println(err)
		return c.NoContent(http.StatusBadRequest)
	}

	result := db.Create(&category)

	if result.Error != nil {
		fmt.Println(result.Error)
		return c.NoContent(http.StatusConflict)
	}

	fmt.Println(category.ID)

	return c.JSON(http.StatusOK, category)
}

func DeleteCategory(c echo.Context) error {
	db := db.DBManager()
	categories := []models.Category{}
	cid := c.Param("cid")

	response := db.Unscoped().Delete(&categories, "id = ?", cid)

	if err := response.Error; err != nil {
		fmt.Println(err)
		return c.NoContent(http.StatusInternalServerError)
	}

	if response.RowsAffected == 0 {
		return c.NoContent(http.StatusNotFound)
	}

	return c.NoContent(http.StatusOK)
}