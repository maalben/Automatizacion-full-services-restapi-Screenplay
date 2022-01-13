package co.com.practice.questions;

import static co.com.practice.utils.GetListFrom.json;
import static co.com.practice.utils.GetListFrom.dataComparision;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static org.junit.Assert.assertArrayEquals;
import static co.com.practice.utils.constants.Constants.VALIDATION_FIELDS;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;
import java.util.*;

public class TheFieldsGetListServiceResponseAre implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        List<String> fieldsProvide = Arrays.asList("id", "email", "first_name", "last_name", "avatar");

        actor.should(
                seeThatResponse(String.format(VALIDATION_FIELDS, "get list"),
                        response -> response.assertThat()
                                .body("$", hasKey("page"))
                                .and().body("$", hasKey("per_page"))
                                .and().body("$", hasKey("total"))
                                .and().body("$", hasKey("total_pages"))
                                .and().body("$", hasKey("data"))
                                .and().body("support", hasKey("url"))
                                .and().body("support", hasKey("text"))
                ));
        assertArrayEquals(json("data").toArray(), dataComparision(fieldsProvide).toArray());
        return true;
    }

    public static TheFieldsGetListServiceResponseAre expected() {
        return new TheFieldsGetListServiceResponseAre();
    }
}
