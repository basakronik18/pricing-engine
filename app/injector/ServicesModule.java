package injector;

import com.google.inject.AbstractModule;
import services.PricingDeterminatorService;
import services.PricingExpressionGenerator;
import services.impl.PricingDeterminatorServiceImpl;
import services.impl.PricingExpressionGeneratorImpl;

public class ServicesModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(PricingDeterminatorService.class).to(PricingDeterminatorServiceImpl.class);
    bind(PricingExpressionGenerator.class).to(PricingExpressionGeneratorImpl.class);
  }
}