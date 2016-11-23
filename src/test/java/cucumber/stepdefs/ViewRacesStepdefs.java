package cucumber.stepdefs;

import cucumber.api.java8.En;

import static cucumber.stepdefs.support.WebDriverFactory.getDriver;

public class ViewRacesStepdefs implements En {
    public ViewRacesStepdefs() {
        When("^I try to view all races$", () -> {
            getDriver().get("http://localhost:8080/EmersonsGame/races");
        });

        Then("^I must see all races$", () -> {
        });
    }
}
