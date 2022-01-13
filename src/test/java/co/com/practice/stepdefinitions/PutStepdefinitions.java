package co.com.practice.stepdefinitions;

import co.com.practice.exceptions.AssertionsServices;
import co.com.practice.models.TestData;
import co.com.practice.questions.*;
import co.com.practice.taks.*;
import co.com.practice.utils.resource.WebServiceEndPoints;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PutStepdefinitions {

    @When("Call Put user API with customer id {int}")
    public void callPutUserAPIWithCustomerId(int id) {
        theActorInTheSpotlight().attemptsTo(
                Create.messageBody("singleuser.json", TestData.getData())
        );
        theActorInTheSpotlight().attemptsTo(
                ConsumePut.service(WebServiceEndPoints.URI.getUrl(), id)
        );
    }

    @Then("Validate field put response api")
    public void validateFieldPutResponseApi() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsPutServiceResponseAre.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_FIELDS_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @Then("Validate put response contain data expected")
    public void validatePutResponseContainDataExpected() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsAndValuesPutResponseAre.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_FIELDS_AND_VALUES_POST_SERVICE_IS_NOT_EXPECTED)
                );
    }
}