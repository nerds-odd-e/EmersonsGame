package cucumber.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class CreateRaceStepdefs implements En {
    public CreateRaceStepdefs() {
        When("^I try to create a new race$", () -> {
            throw new PendingException();
        });

        Then("^I must see the new race$", () -> {
           throw new PendingException();
        });
    }
}
