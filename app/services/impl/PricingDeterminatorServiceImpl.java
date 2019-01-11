package services.impl;

import static utils.ScoreDeterminator.brandFameDeterminator;
import static utils.ScoreDeterminator.deprecationFactorPerYearDeterminator;
import static utils.constants.PricingEngineConstants.HYPHEN;
import static utils.constants.PricingEngineConstants.MAX_LENGTH_OF_EXPRESSION;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parsii.eval.Expression;
import parsii.eval.Parser;
import parsii.eval.Scope;
import parsii.eval.Variable;
import parsii.tokenizer.ParseException;
import services.PricingDeterminatorService;
import services.PricingExpressionGenerator;
import utils.PricingItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class PricingDeterminatorServiceImpl implements PricingDeterminatorService {

  private static final Logger LOGGER = LoggerFactory.getLogger(PricingDeterminatorServiceImpl.class);
  private final PricingExpressionGenerator pricingExpressionGenerator;

  @Inject
  public PricingDeterminatorServiceImpl(PricingExpressionGenerator pricingExpressionGenerator) {
    this.pricingExpressionGenerator = pricingExpressionGenerator;
  }

  @Override
  public Double getPredictedSellingPriceOfItem(PricingItem pricingItem) {
    Scope pricingDeterminatorScope = new Scope();
    Expression pricingDeterminatorExpression = null;
    Variable costOfPurchase = pricingDeterminatorScope.getVariable("costOfPurchase");
    Variable ageOfItem = pricingDeterminatorScope.getVariable("ageOfItem");
    Variable deprecationFactor = pricingDeterminatorScope.getVariable("deprecationFactor");
    Variable itemHealth = pricingDeterminatorScope.getVariable("itemHealth");
    Variable brandFameFactor = pricingDeterminatorScope.getVariable("brandFameFactor");
    try {
      pricingDeterminatorExpression = Parser.parse(pricingExpressionGenerator.generatePricingExpression(), pricingDeterminatorScope);
      costOfPurchase.setValue(pricingItem.getCostOfPurchase());
      ageOfItem.setValue(calculateAgeOfTheItem(pricingItem.getYearOfPurchase()));
      deprecationFactor.setValue(deprecationFactorPerYearDeterminator.get(
          getHyphenConcatenated(
              new ArrayList<String>(Arrays.asList(pricingItem.getItemCategory(), pricingItem.getItemSubCategory()))
          )));
      itemHealth.setValue(pricingItem.getItemHealth());
      brandFameFactor.setValue(brandFameDeterminator.get(pricingItem.getBrand()));
    } catch (ParseException e) {
      LOGGER.error("The expression: {} could not be evaluated as it could not be parsed", pricingExpressionGenerator.generatePricingExpression());
    }
    return pricingDeterminatorExpression.evaluate();
  }


  private Double calculateAgeOfTheItem(Integer yearOfPurchase) {
    Integer age = ((Calendar.getInstance().get(Calendar.YEAR) - yearOfPurchase));
    age = (age > 0) ? age : 1;
    return (double) age;
  }

  private String getHyphenConcatenated(List<String> inputStrings) {
    StringBuffer hyphenConcatenated = new StringBuffer(MAX_LENGTH_OF_EXPRESSION);
    inputStrings.forEach(str -> hyphenConcatenated.append(str).append(HYPHEN));
    return hyphenConcatenated.substring(0,hyphenConcatenated.length()-1);
  }
}
