// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:16
  CategoryController_0: controllers.CategoryController,
  // @LINE:23
  ProductController_1: controllers.ProductController,
  // @LINE:30
  UsersController_2: controllers.UsersController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:16
    CategoryController_0: controllers.CategoryController,
    // @LINE:23
    ProductController_1: controllers.ProductController,
    // @LINE:30
    UsersController_2: controllers.UsersController
  ) = this(errorHandler, CategoryController_0, ProductController_1, UsersController_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, CategoryController_0, ProductController_1, UsersController_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """category""", """controllers.CategoryController.getAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """category/""" + "$" + """itemId<[^/]+>""", """controllers.CategoryController.getById(itemId:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """category/""" + "$" + """itemId<[^/]+>""", """controllers.CategoryController.deleteById(itemId:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """category""", """controllers.CategoryController.addNewItem"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """category/""" + "$" + """itemId<[^/]+>""", """controllers.CategoryController.updateName(itemId:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product""", """controllers.ProductController.getAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product/""" + "$" + """itemId<[^/]+>""", """controllers.ProductController.getById(itemId:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """category/product/""" + "$" + """categoryId<[^/]+>""", """controllers.ProductController.getByCategory(categoryId:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product/""" + "$" + """itemId<[^/]+>""", """controllers.ProductController.update(itemId:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product/""" + "$" + """itemId<[^/]+>""", """controllers.ProductController.deleteById(itemId:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product""", """controllers.ProductController.addNewItem"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UsersController.getAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/""" + "$" + """id<[^/]+>""", """controllers.UsersController.getById(id:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/""" + "$" + """id<[^/]+>""", """controllers.UsersController.update(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/""" + "$" + """id<[^/]+>""", """controllers.UsersController.delete(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UsersController.add"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:16
  private[this] lazy val controllers_CategoryController_getAll0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("category")))
  )
  private[this] lazy val controllers_CategoryController_getAll0_invoker = createInvoker(
    CategoryController_0.getAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "getAll",
      Nil,
      "GET",
      this.prefix + """category""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_CategoryController_getById1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("category/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CategoryController_getById1_invoker = createInvoker(
    CategoryController_0.getById(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "getById",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """category/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_CategoryController_deleteById2_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("category/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CategoryController_deleteById2_invoker = createInvoker(
    CategoryController_0.deleteById(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "deleteById",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """category/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_CategoryController_addNewItem3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("category")))
  )
  private[this] lazy val controllers_CategoryController_addNewItem3_invoker = createInvoker(
    CategoryController_0.addNewItem,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "addNewItem",
      Nil,
      "POST",
      this.prefix + """category""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_CategoryController_updateName4_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("category/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CategoryController_updateName4_invoker = createInvoker(
    CategoryController_0.updateName(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "updateName",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """category/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_ProductController_getAll5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product")))
  )
  private[this] lazy val controllers_ProductController_getAll5_invoker = createInvoker(
    ProductController_1.getAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "getAll",
      Nil,
      "GET",
      this.prefix + """product""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_ProductController_getById6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_getById6_invoker = createInvoker(
    ProductController_1.getById(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "getById",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """product/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_ProductController_getByCategory7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("category/product/"), DynamicPart("categoryId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_getByCategory7_invoker = createInvoker(
    ProductController_1.getByCategory(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "getByCategory",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """category/product/""" + "$" + """categoryId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_ProductController_update8_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_update8_invoker = createInvoker(
    ProductController_1.update(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "update",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """product/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_ProductController_deleteById9_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_deleteById9_invoker = createInvoker(
    ProductController_1.deleteById(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "deleteById",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """product/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_ProductController_addNewItem10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product")))
  )
  private[this] lazy val controllers_ProductController_addNewItem10_invoker = createInvoker(
    ProductController_1.addNewItem,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "addNewItem",
      Nil,
      "POST",
      this.prefix + """product""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_UsersController_getAll11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UsersController_getAll11_invoker = createInvoker(
    UsersController_2.getAll,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "getAll",
      Nil,
      "GET",
      this.prefix + """users""",
      """""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_UsersController_getById12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UsersController_getById12_invoker = createInvoker(
    UsersController_2.getById(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "getById",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """users/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_UsersController_update13_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UsersController_update13_invoker = createInvoker(
    UsersController_2.update(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "update",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """users/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_UsersController_delete14_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UsersController_delete14_invoker = createInvoker(
    UsersController_2.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """users/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_UsersController_add15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UsersController_add15_invoker = createInvoker(
    UsersController_2.add,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "add",
      Nil,
      "POST",
      this.prefix + """users""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:16
    case controllers_CategoryController_getAll0_route(params@_) =>
      call { 
        controllers_CategoryController_getAll0_invoker.call(CategoryController_0.getAll)
      }
  
    // @LINE:17
    case controllers_CategoryController_getById1_route(params@_) =>
      call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        controllers_CategoryController_getById1_invoker.call(CategoryController_0.getById(itemId))
      }
  
    // @LINE:18
    case controllers_CategoryController_deleteById2_route(params@_) =>
      call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        controllers_CategoryController_deleteById2_invoker.call(CategoryController_0.deleteById(itemId))
      }
  
    // @LINE:19
    case controllers_CategoryController_addNewItem3_route(params@_) =>
      call { 
        controllers_CategoryController_addNewItem3_invoker.call(CategoryController_0.addNewItem)
      }
  
    // @LINE:20
    case controllers_CategoryController_updateName4_route(params@_) =>
      call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        controllers_CategoryController_updateName4_invoker.call(CategoryController_0.updateName(itemId))
      }
  
    // @LINE:23
    case controllers_ProductController_getAll5_route(params@_) =>
      call { 
        controllers_ProductController_getAll5_invoker.call(ProductController_1.getAll)
      }
  
    // @LINE:24
    case controllers_ProductController_getById6_route(params@_) =>
      call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        controllers_ProductController_getById6_invoker.call(ProductController_1.getById(itemId))
      }
  
    // @LINE:25
    case controllers_ProductController_getByCategory7_route(params@_) =>
      call(params.fromPath[Long]("categoryId", None)) { (categoryId) =>
        controllers_ProductController_getByCategory7_invoker.call(ProductController_1.getByCategory(categoryId))
      }
  
    // @LINE:26
    case controllers_ProductController_update8_route(params@_) =>
      call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        controllers_ProductController_update8_invoker.call(ProductController_1.update(itemId))
      }
  
    // @LINE:27
    case controllers_ProductController_deleteById9_route(params@_) =>
      call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        controllers_ProductController_deleteById9_invoker.call(ProductController_1.deleteById(itemId))
      }
  
    // @LINE:28
    case controllers_ProductController_addNewItem10_route(params@_) =>
      call { 
        controllers_ProductController_addNewItem10_invoker.call(ProductController_1.addNewItem)
      }
  
    // @LINE:30
    case controllers_UsersController_getAll11_route(params@_) =>
      call { 
        controllers_UsersController_getAll11_invoker.call(UsersController_2.getAll)
      }
  
    // @LINE:31
    case controllers_UsersController_getById12_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UsersController_getById12_invoker.call(UsersController_2.getById(id))
      }
  
    // @LINE:32
    case controllers_UsersController_update13_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UsersController_update13_invoker.call(UsersController_2.update(id))
      }
  
    // @LINE:33
    case controllers_UsersController_delete14_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UsersController_delete14_invoker.call(UsersController_2.delete(id))
      }
  
    // @LINE:34
    case controllers_UsersController_add15_route(params@_) =>
      call { 
        controllers_UsersController_add15_invoker.call(UsersController_2.add)
      }
  }
}
