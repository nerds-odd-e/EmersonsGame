package cucumber.stepdefs.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Browsers {
    private static WebDriver driver;

    public static void openBrowser(final String url) {
        if (driver == null) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
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
