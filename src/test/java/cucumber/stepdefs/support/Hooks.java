package cucumber.stepdefs.support;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import static com.odde.emersonsgame.data.support.Databases.getDatabaseTester;
import static com.odde.emersonsgame.data.support.Databases.getNewDatabaseTester;
import static cucumber.stepdefs.support.Browsers.closeBrowser;

public class Hooks {
    @Before
    public void beforeScenario() throws Exception {
        getNewDatabaseTester();
    }

    @After
    public void afterScenario() throws Exception {
        closeBrowser();
        getDatabaseTester().onTearDown();
    }
}
