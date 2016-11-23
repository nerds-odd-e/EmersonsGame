package cucumber.stepdefs.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDrivers {
    private static WebDriver driver;

    public static WebDriver getNewDriver() {
        return new FirefoxDriver();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = getNewDriver();
        }

        return driver;
    }
}
