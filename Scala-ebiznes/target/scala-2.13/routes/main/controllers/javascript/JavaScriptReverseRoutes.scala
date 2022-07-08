// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:16
package controllers.javascript {

  // @LINE:16
  class ReverseCategoryController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def addNewItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CategoryController.addNewItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "category"})
        }
      """
    )
  
    // @LINE:16
    def getAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CategoryController.getAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "category"})
        }
      """
    )
  
    // @LINE:17
    def getById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CategoryController.getById",
      """
        function(itemId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "category/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("itemId", itemId0))})
        }
      """
    )
  
    // @LINE:18
    def deleteById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CategoryController.deleteById",
      """
        function(itemId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "category/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("itemId", itemId0))})
        }
      """
    )
  
    // @LINE:20
    def updateName: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CategoryController.updateName",
      """
        function(itemId0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "category/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("itemId", itemId0))})
        }
      """
    )
  
  }

  // @LINE:23
  class ReverseProductController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductController.update",
      """
        function(itemId0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "product/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("itemId", itemId0))})
        }
      """
    )
  
    // @LINE:28
    def addNewItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductController.addNewItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "product"})
        }
      """
    )
  
    // @LINE:23
    def getAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductController.getAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product"})
        }
      """
    )
  
    // @LINE:24
    def getById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductController.getById",
      """
        function(itemId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("itemId", itemId0))})
        }
      """
    )
  
    // @LINE:25
    def getByCategory: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductController.getByCategory",
      """
        function(categoryId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "category/product/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("categoryId", categoryId0))})
        }
      """
    )
  
    // @LINE:27
    def deleteById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductController.deleteById",
      """
        function(itemId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "product/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("itemId", itemId0))})
        }
      """
    )
  
  }

  // @LINE:30
  class ReverseUsersController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "users/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:32
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "users/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:30
    def getAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.getAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:34
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.add",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:31
    def getById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.getById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }


}
