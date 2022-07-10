package models

import (
	// "os"
	"fmt"

	jwt "github.com/dgrijalva/jwt-go"
)

type RawUser struct {
	ID					 uint
	Username     		 string
	Email				 string
	Jwt					 string
}

var (
	jwtKey = []byte("test")
)

// GenerateToken : Generate Token
func (u *RawUser) GenerateToken() (string, error) {
	token := jwt.NewWithClaims(jwt.SigningMethodHS256, jwt.MapClaims{
		"ID": u.ID,
		"Username": u.Username,
		"Email": u.Email,
	})

	tokenString, err := token.SignedString(jwtKey)
	u.Jwt = tokenString

	return tokenString, err
}

func (u *RawUser) VerifyToken() {
	if ( u.Jwt != "" ) {
		claims := jwt.MapClaims{}
		_, _ = jwt.ParseWithClaims(u.Jwt, claims, func(token *jwt.Token) (interface{}, error) {
			return jwtKey, nil
		})

		fmt.Println("claims", claims);

		u.ID = uint(claims["ID"].(float64))
	}

}