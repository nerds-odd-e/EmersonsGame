package cucumber.stepdefs.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browsers {
    private static WebDriver driver;

    public static void openBrowser(final String url) {
        if (driver == null) {
            driver = new FirefoxDriver();
        }

        driver.get(url);
    }

    public static WebDriver browser() {
        return driver;
    }

    public static void closeBrowser() {
        if (driver != null) {
            browser().close();
            browser().quit();

            driver = null;
        }
    }
}
