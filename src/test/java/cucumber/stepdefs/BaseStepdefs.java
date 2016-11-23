package cucumber.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseStepdefs {
    private WebDriver driver;

    protected WebDriver getDriver() {
        if (driver == null) {
            driver = new FirefoxDriver();
        }

        return driver;
    }
}
