package cucumber.stepdefs;

import cucumber.api.java8.En;

import static cucumber.stepdefs.support.Url.url;
import static cucumber.stepdefs.support.WebDriverFactory.getDriver;

public class ViewRacesStepdefs implements En {
    public ViewRacesStepdefs() {
        When("^I try to view all races$", () -> {
            getDriver().get(url("/races"));
        });

        Then("^I must see all races$", () -> {
        });
    }
}
