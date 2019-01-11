// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ronik.basak/Documents/Ronik Personal Documents/Self-Help/Pricing/pricing-engine/conf/routes
// @DATE:Sun Jan 06 13:38:20 IST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
