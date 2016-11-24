package cucumber.stepdefs.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDrivers {
    private static WebDriver driver;

    public static WebDriver getNewDriver() {
        driver = new FirefoxDriver();

        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = getNewDriver();
        }

        return driver;
    }
}
