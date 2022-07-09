package db

import (
	"Go-backend/models"
	"gorm.io/driver/sqlite"
	"gorm.io/gorm"
)

var db *gorm.DB
var err error

func Init() {
	db, err = gorm.Open(sqlite.Open("test.db"), &gorm.Config{})
	if err != nil {
		panic("failed to connect database")
	}

	db.AutoMigrate(&models.Category{})
	db.AutoMigrate(&models.Product{})
	db.AutoMigrate(&models.Comment{})
	db.AutoMigrate(&models.User{})
	db.AutoMigrate(&models.Order{})
	//db.AutoMigrate(&models.CreditCard{})
	//db.AutoMigrate(&models.Order{})
	//db.AutoMigrate(&models.User{})

	tvCategory := models.Category{Name: "TV"}
	wmCategory := models.Category{Name: "Pralki"}
	vcCategory := models.Category{Name: "Odkurzacze"}
	db.Create(&tvCategory)
	db.Create(&wmCategory)
	db.Create(&vcCategory)

	var c1 models.Category
	db.First(&c1, "Name = ?", "TV")
	db.Create(&models.Product{
		Name:        "Telewizor 1",
		Description: "Super HD tv",
		Price:       1000,
		CategoryId:  c1.ID,
		Category:    c1,
	})

	db.Create(&models.Comment{Comment: "Jest super", ProductId: 1})
	db.Create(&models.Comment{Comment: "Najlepsza pralka", ProductId: 1})
	db.Create(&models.Comment{Comment: "Działa", ProductId: 1})

}
func DBManager() *gorm.DB {
	return db
}

