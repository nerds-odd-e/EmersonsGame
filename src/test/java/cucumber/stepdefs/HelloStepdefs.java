package cucumber.stepdefs;

import cucumber.api.java8.En;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HelloStepdefs implements En {
    public HelloStepdefs() {
        When("^I try to execute this feature$", () -> {
        });

        Then("^I must see that it works$", () -> {
            assertThat(true, is(true));
        });
    }
}
