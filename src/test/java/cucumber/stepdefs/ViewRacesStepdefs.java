package cucumber.stepdefs;

import cucumber.api.java8.En;

public class ViewRacesStepdefs extends BaseStepdefs implements En {
    public ViewRacesStepdefs() {
        When("^I try to view all races$", () -> {
            getDriver().get("http://localhost:8080/EmersonsGame/races");
        });

        Then("^I must see all races$", () -> {
            getDriver().close();
            getDriver().quit();
        });
    }
}
