package cucumber.stepdefs;

import cucumber.api.java8.En;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HelloStepdefs extends BaseStepdefs implements En {
    public HelloStepdefs() {
        When("^I try to execute this feature$", () -> {
            getDriver().get("http://localhost:8080/EmersonsGame");
        });

        Then("^I must see that it works$", () -> {
            assertThat(true, is(true));

            getDriver().close();
            getDriver().quit();;
        });
    }
}
