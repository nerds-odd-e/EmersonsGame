package cucumber.stepdefs;

import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HelloStepdefs implements En {
    private WebDriver driver = new FirefoxDriver();

    public HelloStepdefs() {
        When("^I try to execute this feature$", () -> {
            driver.get("http://localhost:8080/EmersonsGame");
        });

        Then("^I must see that it works$", () -> {
            assertThat(true, is(true));

            driver.close();
            driver.quit();;
        });
    }
}
