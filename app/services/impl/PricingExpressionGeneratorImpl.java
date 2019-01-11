package services.impl;

import com.google.inject.Inject;
import com.typesafe.config.Config;
import services.PricingExpressionGenerator;
import utils.PlayConfiguration;

public class PricingExpressionGeneratorImpl extends PlayConfiguration implements PricingExpressionGenerator {

  @Inject
  public PricingExpressionGeneratorImpl(Config conf) {
    super(conf);
  }

  @Override
  public String generatePricingExpression() {
    return conf.getString("pricing.calculation.formula");
  }
}
