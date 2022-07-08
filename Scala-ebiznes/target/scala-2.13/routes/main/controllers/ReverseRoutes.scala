// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:16
package controllers {

  // @LINE:16
  class ReverseCategoryController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def addNewItem: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "category")
    }
  
    // @LINE:16
    def getAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "category")
    }
  
    // @LINE:17
    def getById(itemId:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "category/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("itemId", itemId)))
    }
  
    // @LINE:18
    def deleteById(itemId:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "category/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("itemId", itemId)))
    }
  
    // @LINE:20
    def updateName(itemId:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "category/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("itemId", itemId)))
    }
  
  }

  // @LINE:23
  class ReverseProductController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def update(itemId:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "product/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("itemId", itemId)))
    }
  
    // @LINE:28
    def addNewItem: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "product")
    }
  
    // @LINE:23
    def getAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "product")
    }
  
    // @LINE:24
    def getById(itemId:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "product/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("itemId", itemId)))
    }
  
    // @LINE:25
    def getByCategory(categoryId:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "category/product/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("categoryId", categoryId)))
    }
  
    // @LINE:27
    def deleteById(itemId:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "product/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("itemId", itemId)))
    }
  
  }

  // @LINE:30
  class ReverseUsersController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def delete(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "users/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:32
    def update(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "users/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:30
    def getAll: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:34
    def add: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:31
    def getById(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }


}
