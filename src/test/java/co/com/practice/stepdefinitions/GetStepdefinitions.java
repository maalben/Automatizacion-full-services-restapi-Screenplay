package co.com.practice.stepdefinitions;

import co.com.practice.exceptions.AssertionsServices;
import co.com.practice.questions.*;
import co.com.practice.taks.*;
import co.com.practice.utils.resource.WebServiceEndPoints;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetStepdefinitions {

    @When("Call Get user API")
    public void callGetUserAPI() {
        theActorInTheSpotlight().attemptsTo(
                ConsumeGet.service(
                        WebServiceEndPoints.URI.getUrl()
                ));
    }

    @Then("Validate field get response api")
    public void validateFieldGetResponseApi() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsGetServiceResponseAre.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_FIELDS_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @Then("Validate fields get list response api")
    public void validateFieldsGetListResponseApi() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsGetListServiceResponseAre.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_FIELDS_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @Then("Validate get response contain data expected")
    public void validateGetResponseContainDataExpected() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsAndValuesGetResponseAre.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_FIELDS_AND_VALUES_POST_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @Then("Validate list get response contain data expected")
    public void validateListGetResponseContainDataExpected(List<Map<String, String>> dataValidation) {
        theActorInTheSpotlight().wasAbleTo(
                Load.testData(dataValidation.get(0))
        );
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsAndValuesListGetResponseAre.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_FIELDS_SERVICE_IS_NOT_EXPECTED)
                );
    }
}