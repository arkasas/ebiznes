package api

import (
	"Go-backend/db"
	"Go-backend/models"
	"encoding/json"
	"fmt"
	"github.com/labstack/echo/v4"
	"io/ioutil"
	"net/http"
	"time"

	"golang.org/x/oauth2"
	"golang.org/x/oauth2/google"
	// "encoding/json"
	"os"
)


var (
	googleOauthConfig *oauth2.Config
	githubOauthConfig *oauth2.Config
	oauthStateString = "pseudo-random"
)


func OauthConfigInit() {
	os.Setenv("GOOGLE_CLIENT_ID", "300449152833-5tt7tpb4efp9tarmv3l24k9khfgrofgl.apps.googleusercontent.com")
	os.Setenv("GOOGLE_CLIENT_SECRET", "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")

	googleOauthConfig = &oauth2.Config{
		RedirectURL:  "http://localhost:1323/auth/callback/google",
		ClientID:     os.Getenv("GOOGLE_CLIENT_ID"),
		ClientSecret: os.Getenv("GOOGLE_CLIENT_SECRET"),
		Scopes:       []string{"https://www.googleapis.com/auth/userinfo.email"},
		Endpoint:     google.Endpoint,
	}

}

func HandleGoogleLogin(c echo.Context) error {
	url := googleOauthConfig.AuthCodeURL(oauthStateString)
	return c.Redirect(http.StatusTemporaryRedirect, url)
}

func HandleGoogleCallback(c echo.Context) error {
	contents, err := getUserInfoGoogle(c.FormValue("state"), c.FormValue("code"))

	if err != nil {
		fmt.Println(err.Error())
		c.Redirect(http.StatusTemporaryRedirect, "http://localhost:3000/");
	}

	userinfo := new(models.User)
	json.Unmarshal([]byte(string(contents)), &userinfo)

	dbUser, err := doesUserAlreadyExist(userinfo.Email)
	if err != nil {
		fmt.Println(err.Error())
		c.Redirect(http.StatusTemporaryRedirect, "http://localhost:3000/");
	}

	user := models.RawUser{ID: dbUser.ID, Username: userinfo.Email, Email: userinfo.Email}
	user.GenerateToken()

	userStr, err := json.Marshal(user)

	cookieUser := new(http.Cookie)
	cookieUser.Path = "/logged"
	cookieUser.Name = "user"
	cookieUser.Value = string(userStr)
	cookieUser.Expires = time.Now().Add(30*time.Second)
	cookieUser.HttpOnly = false
	cookieUser.Secure = true
	c.SetCookie(cookieUser)

	return c.Redirect(http.StatusSeeOther, "http://localhost:3000/logged?token="+user.Jwt);
}

func getUserInfoGoogle(state string, code string) ([]byte, error) {
	fmt.Println("Pbeirema")
	if state != oauthStateString {
		return nil, fmt.Errorf("invalid oauth state")
	}
	token, err := googleOauthConfig.Exchange(oauth2.NoContext, code)
	if err != nil {
		return nil, fmt.Errorf("code exchange failed: %s", err.Error())
	}

	response, err := http.Get("https://www.googleapis.com/oauth2/v2/userinfo?access_token=" + token.AccessToken)

	if err != nil {
		return nil, fmt.Errorf("failed getting user info: %s", err.Error())
	}
	defer response.Body.Close()
	contents, err := ioutil.ReadAll(response.Body)
	if err != nil {
		return nil, fmt.Errorf("failed reading response body: %s", err.Error())
	}

	userinfo := new(models.User)
	json.Unmarshal([]byte(string(contents)), &userinfo)

	db := db.DBManager()
	//db.Where("Username LIKE ?", userinfo.Email).Delete(&models.User{})
	//_, err = doesUserAlreadyExist(userinfo.Email)
	user := models.User{ Username: userinfo.Email, Email: userinfo.Email, Access_token: token.AccessToken	}
	//db := db.DBManager()

	result := db.Create(&user)

	if result.Error != nil {
		fmt.Println(result.Error)
		fmt.Println("Niie dziala")
	}
	////db.Delete(&models.User{}, 0)
	//if err != nil {
	//	fmt.Println("User nie stneieje")
	//	user := models.User{ Username: userinfo.Email, Email: userinfo.Email, Access_token: token.AccessToken	}
	//	//db := db.DBManager()
	//
	//	result := db.Create(&user)
	//
	//	if result.Error != nil {
	//		fmt.Println(result.Error)
	//		fmt.Println("Niie dziala")
	//	}
	//
	//
	//} else {
	//	fmt.Println("User istnieje")
	//}


	fmt.Println(user)

	fmt.Println("User Id=", user.ID)
	return contents, nil
}

func doesUserAlreadyExist(username string) (*models.User, error) {
	db := db.DBManager()
	dbUser := models.User{}
	fmt.Println(username)
	if err := db.Find(&dbUser, "Username=?", username).Error; err != nil {
		return nil, err
	}

	return &dbUser, nil
}