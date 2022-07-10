package api

import (
	"Go-backend/db"
	"Go-backend/models"
	"fmt"
	"github.com/labstack/echo/v4"
	"net/http"
)

func GetComments(c echo.Context) error {
	db := db.DBManager()
	comments := []models.Comment{}

	if err := db.Find(&comments).Error; err != nil {
		fmt.Println(err)
		return c.NoContent(http.StatusInternalServerError)
	}

	return c.JSON(http.StatusOK, comments)
}

func AddComment(c echo.Context) error {
	db := db.DBManager()

	comment := new(models.Comment)
	if err := c.Bind(comment); err != nil {
		fmt.Println(err)
		return c.NoContent(http.StatusNotFound)
	}

	product := new(models.Product)
	if err := db.First(&product, comment.ProductId).Error; err != nil {
		fmt.Println(err)
		return c.NoContent(http.StatusBadRequest)
	}

	result := db.Create(&comment)

	if result.Error != nil {
		fmt.Println(result.Error)
		return c.NoContent(http.StatusInternalServerError)
	}

	db.Preload("Comment").Find(&product)

	return c.JSON(http.StatusOK, comment)
}

func DeleteComment(c echo.Context) error {
	db := db.DBManager()
	comments := []models.Comment{}
	cid := c.Param("cid")

	response := db.Unscoped().Delete(&comments, "ID = ?", cid)

	fmt.Println(response)
	if err := response.Error; err != nil {
		fmt.Println(err)
		return c.NoContent(http.StatusInternalServerError)
	}

	if response.RowsAffected == 0 {
		return c.NoContent(http.StatusNotFound)
	}

	return c.NoContent(http.StatusOK)
}