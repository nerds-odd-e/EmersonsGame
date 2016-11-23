package cucumber.stepdefs.support;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import static cucumber.stepdefs.support.Url.url;
import static cucumber.stepdefs.support.WebDriverFactory.getDriver;

public class Hooks {
    @Before
    public void beforeScenario() {
        getDriver(true).get(url());
    }

    @After
    public void afterScenario() {
        getDriver().close();
        getDriver().quit();
    }
}
