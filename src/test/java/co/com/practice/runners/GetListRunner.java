package co.com.practice.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        features = "src/test/resources/features/get_list.feature",
        glue = {"co.com.practice.stepdefinitions.hook",
                "co.com.practice.stepdefinitions"
        }
)
public class GetListRunner {
}
