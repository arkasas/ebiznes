package models

import "gorm.io/gorm"

type Order struct {
	gorm.Model
	id					uint64		`gorm:"primary_key"`
	ProductId     		uint
	Product     		Product `gorm:"foreignKey:ID"`
	UserId 				uint
	User				User 	`gorm:"foreignKey:ID"`
}
