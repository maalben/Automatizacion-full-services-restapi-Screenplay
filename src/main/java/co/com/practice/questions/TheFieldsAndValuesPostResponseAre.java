package co.com.practice.questions;

import co.com.practice.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.com.practice.utils.constants.Constants.VALIDATION_FIELDS_AND_VALUES;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class TheFieldsAndValuesPostResponseAre implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse(String.format(VALIDATION_FIELDS_AND_VALUES, "post"),
                        response -> response
                                .assertThat()
                                .body("name", equalTo(TestData.getData().get("name")))
                                .body("job", equalTo(TestData.getData().get("job")))
                ));
        return true;
    }

    public static TheFieldsAndValuesPostResponseAre expected() {
        return new TheFieldsAndValuesPostResponseAre();
    }
}
