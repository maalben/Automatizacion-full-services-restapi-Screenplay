package co.com.practice.questions;

import static co.com.practice.utils.TimeZone.validation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.com.practice.utils.constants.Constants.TIME_ZONE;
import static co.com.practice.utils.constants.Constants.VALIDATION_FIELDS_AND_VALUES;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class TheFieldsAndValuesPutResponseAre implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse(String.format(VALIDATION_FIELDS_AND_VALUES, "put"),
                        response -> response
                                .assertThat()
                                .body("name", equalTo("morpheus"))
                                .and().body("job", equalTo("leader"))
                                .and().body("updatedAt", containsString(validation(TIME_ZONE[0])))
                ));
        return true;
    }

    public static TheFieldsAndValuesPutResponseAre expected() {
        return new TheFieldsAndValuesPutResponseAre();
    }
}
