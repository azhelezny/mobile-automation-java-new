package steps;

import appium.BaseTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import po.hello_kitty.HelloKittyPage;

/**
 * @author Andrey Zhelezny
 *         Date: 3/5/18
 */
public class HelloKittySteps extends BaseTest {
    private HelloKittyPage helloKittyPage;

    @Given("^I am on HelloKitty application main page$")
    public void I_am_on_HelloKitty_application_main_page() {
        helloKittyPage = new HelloKittyPage(driver);
    }

    @When("^I type \"([^\"]*)\"$")
    public void i_type(String text) {
        helloKittyPage.setText(text);
    }

    @Then("^I see \"([^\"]*)\"$")
    public void I_see(String text) {
        Assert.assertEquals(helloKittyPage.getCaption(), text);
    }
}
