package co.com.practice.stepdefinitions;

import co.com.practice.exceptions.AssertionsServices;
import co.com.practice.questions.*;
import co.com.practice.taks.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CommonsStepsdefinitions {

    @Given("Load customer information")
    public void loadCustomerInformation(List<Map<String, String>> clientDetails) {
        theActorInTheSpotlight().wasAbleTo(
                Load.testData(clientDetails.get(0))
        );
    }

    @Then("Should see the code {int}")
    public void shouldSeeTheCode(int responseCode) {
        theActorInTheSpotlight()
                .should(seeThat(StatusCode.is(responseCode))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @Then("Validate schema request {string}")
    public void validateSchemaRequest(String schemaResponse) {
        theActorInTheSpotlight()
                .should(seeThat(TheSchemaIs.expected(schemaResponse))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.SCHEMA_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @Then("Validate quantity key is {int}")
    public void validateQuantityKeyIs(int quantity) {
        theActorInTheSpotlight()
                .should(seeThat(TheQuantityFieldsService.are(quantity))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.QUANTITY_FIELDS_SERVICE_IS_NOT_EXPECTED)
                );
    }
}