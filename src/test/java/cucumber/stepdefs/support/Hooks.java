package cucumber.stepdefs.support;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import static com.odde.emersonsgame.data.support.Databases.getDatabaseTester;
import static com.odde.emersonsgame.data.support.Databases.getNewDatabaseTester;
import static cucumber.stepdefs.support.Url.url;
import static cucumber.stepdefs.support.WebDrivers.getDriver;

public class Hooks {
    @Before
    public void beforeScenario() throws Exception {
        getNewDatabaseTester();
        getDriver(true).get(url());
    }

    @After
    public void afterScenario() throws Exception {
        getDriver().close();
        getDriver().quit();
        getDatabaseTester().onTearDown();
    }
}
