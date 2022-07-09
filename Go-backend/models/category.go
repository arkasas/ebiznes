package models

import (
	"gorm.io/gorm"
)

type Category struct {
	gorm.Model
	ID			uint	`gorm:"primary_key"`
	Name		string	`gorm:"unique"`
}
