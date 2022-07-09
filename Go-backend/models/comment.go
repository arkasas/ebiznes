package models

import (
	"gorm.io/gorm"
)

type Comment struct {
	gorm.Model
	ID			uint	`gorm:"primary_key"`
	UserId		uint
	ProductId   uint
	Comment		string
	Product		Product 	`gorm:"foreignKey:ID"`
}
