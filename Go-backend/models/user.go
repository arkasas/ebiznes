package models

import (
	"golang.org/x/crypto/bcrypt"
	"gorm.io/gorm"
)

type User struct {
	gorm.Model
	Username     		 string	`gorm:"unique"`
	PasswordHash		 string
	Email				 string
	Access_token 		 string
}

// HashPassword : Hash Password
func (u *User) HashPassword() {
	bytes, _ := bcrypt.GenerateFromPassword([]byte(u.PasswordHash), bcrypt.DefaultCost)
	u.PasswordHash = string(bytes)
}

func (u *User) CompareHashedPassword(passDb string) error {
	err := bcrypt.CompareHashAndPassword([]byte(u.PasswordHash), []byte(passDb))
	if err != nil {
		return err
	}

	return nil
}