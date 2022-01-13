package co.com.practice.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.com.practice.utils.constants.Constants.VALIDATION_FIELDS;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.hasKey;

public class TheFieldsGetServiceResponseAre implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse(String.format(VALIDATION_FIELDS, "get"),
                        response -> response.assertThat()
                                .body("$", hasKey("data"))
                                .and().body("data", hasKey("id"))
                                .and().body("data", hasKey("email"))
                                .and().body("data", hasKey("first_name"))
                                .and().body("data", hasKey("last_name"))
                                .and().body("data", hasKey("avatar"))
                                .and().body("$", hasKey("support"))
                                .and().body("support", hasKey("url"))
                                .and().body("support", hasKey("text"))
                ));
        return true;
    }

    public static TheFieldsGetServiceResponseAre expected() {
        return new TheFieldsGetServiceResponseAre();
    }
}
