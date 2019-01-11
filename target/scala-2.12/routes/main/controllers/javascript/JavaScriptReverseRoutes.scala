// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ronik.basak/Documents/Ronik Personal Documents/Self-Help/Pricing/pricing-engine/conf/routes
// @DATE:Sun Jan 06 13:38:20 IST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:11
package controllers.javascript {

  // @LINE:11
  class ReversePricingEngineController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def calculatePrice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PricingEngineController.calculatePrice",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "internal/v1.0/calculate/pricing"})
        }
      """
    )
  
  }


}
