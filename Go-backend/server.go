package main

import (
	"Go-backend/db"
	"Go-backend/route"
)

func main() {
	db.Init()
	e := route.Init()
	e.Logger.Fatal(e.Start(":1323"))
}
