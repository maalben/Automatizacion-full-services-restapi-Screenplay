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

public class PostStepdefinitions {

    @When("Call Post user API")
    public void callPostUserAPI() {
        theActorInTheSpotlight().attemptsTo(
                Create.messageBody("singleuser.json", TestData.getData())
        );
        theActorInTheSpotlight().attemptsTo(
                ConsumePost.service(WebServiceEndPoints.URI.getUrl())
        );
    }

    @Then("Validate field post response api")
    public void validateFieldPostResponseApi() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsPostServiceResponseAre.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_FIELDS_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @Then("Validate post response contain data initial")
    public void validatePostResponseContainDataInitial() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsAndValuesPostResponseAre.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_FIELDS_AND_VALUES_POST_SERVICE_IS_NOT_EXPECTED)
                );
    }
}