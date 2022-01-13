package co.com.practice.runners;

import static io.cucumber.junit.CucumberOptions.SnippetType;

import co.com.practice.utils.exceldata.BeforeSuite;
import co.com.practice.utils.exceldata.DataToFeature;
import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(CustomRunner.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        features = "src/test/resources/features/post.feature",
        glue = {"co.com.practice.stepdefinitions.hook",
                "co.com.practice.stepdefinitions"
        }
)
public class PostRunner {
        @BeforeSuite
        public static void test() throws IOException, InvalidFormatException {
                DataToFeature.overrideFeatureFiles("./src/test/resources/features/post.feature");
        }
}
