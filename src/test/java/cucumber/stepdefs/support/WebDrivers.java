package cucumber.stepdefs.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDrivers {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return getDriver(false);
    }

    public static WebDriver getDriver(boolean reset) {
        if (reset || (driver == null)) {
            driver = new FirefoxDriver();
        }

        return driver;
    }
}
