package cucumber.stepdefs.support;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import static cucumber.stepdefs.support.WebDriverFactory.getDriver;

public class Hooks {
    @Before
    public void beforeScenario() {
        getDriver(true).get("http://localhost:8080/EmersonsGame");
    }

    @After
    public void afterScenario() {
        getDriver().close();
        getDriver().quit();
    }
}
