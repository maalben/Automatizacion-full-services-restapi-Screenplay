package co.com.practice.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.com.practice.utils.constants.Constants.VALIDATION_FIELDS;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.hasKey;

public class TheFieldsPostServiceResponseAre implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse(String.format(VALIDATION_FIELDS, "post"),
                        response -> response.assertThat()
                                .body("$", hasKey("name"))
                                .and().body("$", hasKey("job"))
                                .and().body("$", hasKey("id"))
                                .and().body("$", hasKey("createdAt"))
                ));
        return true;
    }

    public static TheFieldsPostServiceResponseAre expected() {
        return new TheFieldsPostServiceResponseAre();
    }
}
