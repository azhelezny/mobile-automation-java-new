package steps;

import appium.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * @author Andrey Zhelezny
 *         Date: 3/5/18
 */
public class CommonSteps extends BaseTest {

    @Before
    public void beforeScenario() throws Exception {
        setUpTest();
    }

    @After
    public void afterScenario(Scenario scenario) {
        /* take screenshot if the scenario failed */
        if (scenario.isFailed()) {
            takeScreenshot("Screenshot Taken After Error");
        }
        quitAppiumSession();
   }
}
