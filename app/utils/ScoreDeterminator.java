package utils;

import com.google.common.collect.ImmutableMap;

public class ScoreDeterminator {

  //PricingItem-level attribute will be set for every combination of category-subcategory-brand of item.
  // Unique for the composite-key of the same.
  public static final ImmutableMap<String, Double> deprecationFactorPerYearDeterminator =
      ImmutableMap.<String, Double>builder()
      .put("book-technical", 0.5)
          .put("book-competitiveexams", 0.75)
      .build();

  //PricingItem-level attribute will be set for every brand of item.
  // Unique for the the brand.
  public static final ImmutableMap<String, Double> brandFameDeterminator =
      ImmutableMap.<String, Double>builder()
      .put("pearson", 0.75)
      .put("hot-wheels", 1.0)
      .build();
}
