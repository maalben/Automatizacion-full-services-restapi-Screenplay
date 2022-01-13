package co.com.practice.interactions;

import co.com.practice.exceptions.ErrorServicesException;
import co.com.practice.models.TestData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import org.apache.http.HttpStatus;
import static co.com.practice.utils.constants.Constants.EXCEPTION_ERROR_CONSUMPTION_SERVICE;
import static io.restassured.http.ContentType.JSON;

public class ExecuteDelete implements Interaction {
    private final String resource;

    public ExecuteDelete(String resource) {
        this.resource = resource;
    }

    public static ExecuteDelete service(String resource) {
        return Tasks.instrumented(ExecuteDelete.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Delete.from(resource)
                        .with(request -> request.
                                contentType(JSON).params(TestData.getData())
                                .relaxedHTTPSValidation()
                        )
        );

        if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_NO_CONTENT){
            throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
        }
    }
}