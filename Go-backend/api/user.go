package api

import (
	"Go-backend/db"
	"Go-backend/models"
	"fmt"
	"github.com/labstack/echo/v4"
	"net/http"
)

func GetUsers(c echo.Context) error {
	db := db.DBManager()
	users := []models.User{}

	if err := db.Find(&users).Error; err != nil {
		fmt.Println(err)
		return c.NoContent(http.StatusInternalServerError)
	}

	// spew.Dump(json.Marshal(users))
	// return c.JSON(http.StatusOK, users)
	return c.JSON(http.StatusOK, users)
}

func AddUser(c echo.Context) error {
	db := db.DBManager()

	user := new(models.User)
	if err := c.Bind(user); err != nil {
		fmt.Println(err)
		return c.JSON(http.StatusBadRequest, user)
	}

	user.HashPassword()

	result := db.Create(&user)

	if result.Error != nil {
		fmt.Println(result.Error)
		return c.NoContent(http.StatusConflict)
	}

	fmt.Println(user.ID)

	return c.JSON(http.StatusOK, user)
}

func DeteleUser(c echo.Context) error {
	db := db.DBManager()
	users := []models.User{}
	uid := c.Param("uid")

	response := db.Unscoped().Delete(&users, "id = ?", uid);

	if err := response.Error; err != nil {
		// panic(err)
		fmt.Println(err)
		return c.NoContent(http.StatusInternalServerError)
	}

	if response.RowsAffected == 0 {
		return c.NoContent(http.StatusNotFound)
	}

	// spew.Dump(json.Marshal(carts))
	// return c.JSON(http.StatusOK, carts)
	return c.NoContent(http.StatusOK)
}
