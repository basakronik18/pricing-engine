// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ronik.basak/Documents/Ronik Personal Documents/Self-Help/Pricing/pricing-engine/conf/routes
// @DATE:Sun Jan 06 13:38:20 IST 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReversePricingEngineController PricingEngineController = new controllers.ReversePricingEngineController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReversePricingEngineController PricingEngineController = new controllers.javascript.ReversePricingEngineController(RoutesPrefix.byNamePrefix());
  }

}
