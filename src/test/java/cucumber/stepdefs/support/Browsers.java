package cucumber.stepdefs.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browsers {
    private static WebDriver driver;

    public static WebDriver getNewDriver() {
        driver = new FirefoxDriver();

        return driver;
    }

    public static WebDriver browser() {
        return driver;
    }
}
