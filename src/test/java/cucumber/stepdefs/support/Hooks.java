package cucumber.stepdefs.support;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import static com.odde.emersonsgame.data.support.Databases.getDatabaseTester;
import static com.odde.emersonsgame.data.support.Databases.getNewDatabaseTester;
import static cucumber.stepdefs.support.Url.url;
import static cucumber.stepdefs.support.Browsers.browser;
import static cucumber.stepdefs.support.Browsers.openBrowser;

public class Hooks {
    @Before
    public void beforeScenario() throws Exception {
        getNewDatabaseTester();
        openBrowser().get(url());
    }

    @After
    public void afterScenario() throws Exception {
        browser().close();
        browser().quit();
        getDatabaseTester().onTearDown();
    }
}
