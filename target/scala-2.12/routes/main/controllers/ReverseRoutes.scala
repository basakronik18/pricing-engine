// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ronik.basak/Documents/Ronik Personal Documents/Self-Help/Pricing/pricing-engine/conf/routes
// @DATE:Sun Jan 06 13:38:20 IST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:11
package controllers {

  // @LINE:11
  class ReversePricingEngineController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def calculatePrice(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "internal/v1.0/calculate/pricing")
    }
  
  }


}
