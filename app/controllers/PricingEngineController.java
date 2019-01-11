package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.mvc.*;
import services.PricingDeterminatorService;
import utils.PricingItem;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class PricingEngineController extends Controller {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final PricingDeterminatorService pricingDeterminatorService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PricingEngineController.class);

    @Inject
    public PricingEngineController(PricingDeterminatorService pricingDeterminatorService) {
        this.pricingDeterminatorService = pricingDeterminatorService;
    }


    @BodyParser.Of(BodyParser.Json.class)
    public Result calculatePrice() {
        try {
            final PricingItem pricingItem = getJsonPricingItem(request().body());
            Double predictedPriceDouble = pricingDeterminatorService.getPredictedSellingPriceOfItem(pricingItem);
            BigDecimal predictedPrice = new BigDecimal(predictedPriceDouble);
            predictedPrice = predictedPrice.setScale(2, RoundingMode.HALF_UP);
            LOGGER.info("Predicted Price for the item: {} is: {}", pricingItem.getItemDescription(), predictedPrice.doubleValue());
            return ok("Predicted Price: " + predictedPrice.doubleValue());
        } catch (Exception e) {
            LOGGER.error("Exception occurred while getting Item payload for price determination");
            return internalServerError("Oops! Price could not be predicted for item: ");
        }
    }

    private PricingItem getJsonPricingItem(Http.RequestBody body) throws Exception {
        JsonNode jsonBody = body.asJson();
        if (jsonBody == null) {
            throw new Exception("Json body for item to determine price is null!!");
        } else {
            LOGGER.info("JSON BODY for item to determine the price: {}", jsonBody.toString());
        }
        return objectMapper.readValue(jsonBody.toString(), PricingItem.class);

    }


}
