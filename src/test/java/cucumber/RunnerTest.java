package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/html/", "json:target/cucumber.json", "junit:TEST-all.xml" },
features = "src/test/resources", glue = { "steps" }, tags = { "@Sanity"})
public class RunnerTest {

}