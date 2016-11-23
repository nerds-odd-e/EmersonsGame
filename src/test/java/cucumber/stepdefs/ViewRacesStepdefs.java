package cucumber.stepdefs;

import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static cucumber.stepdefs.support.Url.url;
import static cucumber.stepdefs.support.WebDriverFactory.getDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ViewRacesStepdefs implements En {
    public ViewRacesStepdefs() {
        When("^I try to view all races$", () -> {
            getDriver().get(url("/races"));
        });

        Then("^I must see all races$", () -> {
            List<WebElement> rows = getDriver().findElements(By.cssSelector("#races tbody tr"));

            assertThat(rows.size(), is(2));
        });
    }
}
