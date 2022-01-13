package co.com.practice.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.com.practice.models.TestData.getData;
import static co.com.practice.utils.constants.Constants.VALIDATION_FIELDS_AND_VALUES;
import static java.lang.Integer.parseInt;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class TheFieldsAndValuesListGetResponseAre implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse(String.format(VALIDATION_FIELDS_AND_VALUES, "list get"),
                        response -> response
                                .assertThat()
                                .body("page", equalTo(parseInt(getData().get("page").toString())))
                                .and().body("per_page", equalTo(parseInt(getData().get("per_page").toString())))
                                .and().body("total", equalTo(parseInt(getData().get("total").toString())))
                                .and().body("total_pages", equalTo(parseInt(getData().get("total_pages").toString())))
                                .and().body("support.url", equalTo(getData().get("support_url").toString()))
                                .and().body("support.text", equalTo(getData().get("support_text").toString()))
                                .and().body("data[0].id", equalTo(parseInt(getData().get("id").toString())))
                                .and().body("data[0].email", equalTo(getData().get("email").toString()))
                                .and().body("data[0].first_name", equalTo(getData().get("first_name").toString()))
                                .and().body("data[0].last_name", equalTo(getData().get("last_name").toString()))
                                .and().body("data[0].avatar", equalTo(getData().get("avatar").toString()))
                ));
        return true;
    }

    public static TheFieldsAndValuesListGetResponseAre expected() {
        return new TheFieldsAndValuesListGetResponseAre();
    }
}
