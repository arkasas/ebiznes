package route

import (
	"Go-backend/api"
	"github.com/labstack/echo/v4"
	"github.com/labstack/echo/v4/middleware"
	"net/http"
)

func Init() *echo.Echo {
	e := echo.New()
	api.OauthConfigInit()

	// Middleware
	e.Use(middleware.Logger())
	e.Use(middleware.Recover())

	e.Use(middleware.CORSWithConfig(middleware.CORSConfig{
		AllowOrigins: []string{"*"},
		AllowMethods: []string{echo.GET, echo.HEAD, echo.PUT, echo.PATCH, echo.POST, echo.DELETE},
	}))

	// Routes
	e.GET("/", hello)

	e.GET("/categories", api.GetCategories)
	e.POST("/categories", api.AddCategory)
	e.DELETE("/categories/:cid", api.DeleteCategory)

	e.GET("/products", api.GetProducts)
	e.POST("/products", api.AddProduct)
	e.DELETE("/products/:pid", api.DeteleProduct)

	e.GET("/comments", api.GetComments)
	e.POST("/comments", api.AddComment)
	e.DELETE("/comments/:pid", api.DeleteComment)

	e.GET("/users", api.GetUsers)
	e.POST("/users", api.AddUser)
	e.DELETE("/users/:uid", api.DeteleUser)

	e.GET("/order/:uid", api.GetOrder)
	e.POST("/order", api.AddToOrder)

	e.POST("/payment/:uid", api.OrderAndPay)

	e.POST("/auth/signin", api.SignIn)
	e.POST("/auth/login", api.LogIn)

	e.GET("/auth/login/google", api.HandleGoogleLogin)
	e.GET("/auth/callback/google", api.HandleGoogleCallback)

	// Start server
	e.Logger.Fatal(e.Start(":1323"))

	return e
}
// Handler
func hello(c echo.Context) error {
	return c.String(http.StatusOK, "Hello, World!")
}
