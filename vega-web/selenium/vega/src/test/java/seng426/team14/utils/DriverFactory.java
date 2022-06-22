package seng426.team14.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

/**
 * singleton pattern for factory
 */
public class DriverFactory {
    private static DriverFactory instance = new DriverFactory(); //early installation, create an object at load time

    private DriverFactory() {
        //Singleton..Do not allow to initialize this class from outside
    }

    public static DriverFactory getInstance() {
        return instance;
    }

    private WebDriver initDriver(boolean runBackground) {
        WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-102.0.5005.61.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(runBackground);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    // create a local thread for the driver object for the web driver
    ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            WebDriver driver = null;
            try {
                driver = initDriver(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return driver;
        }
    };

    // call this method to get the driver object and launch the browser
    public WebDriver getDriver() {
        return threadLocal.get();
    }

    // Quits the driver and closes the browser
    public void removeDriver() {
        threadLocal.get().quit();
        threadLocal.remove();
    }
}