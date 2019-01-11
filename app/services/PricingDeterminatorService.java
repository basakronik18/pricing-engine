package services;

import utils.PricingItem;

public interface PricingDeterminatorService {

  Double getPredictedSellingPriceOfItem(PricingItem pricingItem);
}
