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
		fmt.Println(err)
		return c.NoContent(http.StatusInternalServerError)
	}

	if response.RowsAffected == 0 {
		return c.NoContent(http.StatusNotFound)
	}

	return c.NoContent(http.StatusOK)
}

func SignIn(c echo.Context) error {

	response, user := createUser(c)

	if (response != nil) {
		return response
	}

	return c.JSON(http.StatusOK, user);
}

func createUser(c echo.Context) (error, *models.RawUser) {
	db := db.DBManager()

	user := new(models.User)
	if err := c.Bind(user); err != nil {
		fmt.Println(err)
		return c.JSON(http.StatusBadRequest, user), nil
	}

	user.HashPassword()

	result := db.Create(&user)

	if result.Error != nil {
		return c.NoContent(http.StatusConflict), nil
	}

	userClean := models.RawUser{ID: user.ID, Username: user.Username, Email: user.Email}
	userClean.GenerateToken()

	return nil, &userClean
}


func LogIn(c echo.Context) error {
	db := db.DBManager()

	user := new(models.User)
	if err := c.Bind(user); err != nil {
		fmt.Println(err)
		return c.NoContent(http.StatusBadRequest)
	}

	userdb := new(models.User)
	response := db.Where("username = ?", user.Username ).First(&userdb);
	if err := response.Error; err != nil {
		return c.NoContent(http.StatusNotFound)
	}

	err := userdb.CompareHashedPassword(user.PasswordHash)
	if err != nil {
		return c.NoContent(http.StatusBadRequest)
	}

	rawUser := models.RawUser{ID: userdb.ID, Username: userdb.Username, Email: userdb.Email}
	rawUser.GenerateToken()

	return c.JSON(http.StatusOK, rawUser);
}
