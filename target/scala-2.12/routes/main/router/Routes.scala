// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ronik.basak/Documents/Ronik Personal Documents/Self-Help/Pricing/pricing-engine/conf/routes
// @DATE:Sun Jan 06 13:38:20 IST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:11
  PricingEngineController_0: controllers.PricingEngineController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:11
    PricingEngineController_0: controllers.PricingEngineController
  ) = this(errorHandler, PricingEngineController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, PricingEngineController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """internal/v1.0/calculate/pricing""", """controllers.PricingEngineController.calculatePrice()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:11
  private[this] lazy val controllers_PricingEngineController_calculatePrice0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("internal/v1.0/calculate/pricing")))
  )
  private[this] lazy val controllers_PricingEngineController_calculatePrice0_invoker = createInvoker(
    PricingEngineController_0.calculatePrice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PricingEngineController",
      "calculatePrice",
      Nil,
      "POST",
      this.prefix + """internal/v1.0/calculate/pricing""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:11
    case controllers_PricingEngineController_calculatePrice0_route(params@_) =>
      call { 
        controllers_PricingEngineController_calculatePrice0_invoker.call(PricingEngineController_0.calculatePrice())
      }
  }
}
