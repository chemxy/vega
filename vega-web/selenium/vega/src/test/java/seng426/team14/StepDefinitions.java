package seng426.team14;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import seng426.team14.utils.DriverFactory;
import seng426.team14.utils.Util;

public class StepDefinitions {

    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.out.println("DEBUG: before method: init driver");
        driver = DriverFactory.getInstance().getDriver();
        System.out.printf("DEBUG: Current Thread ID - %d\nThread Name - %s\nCurrent Driver - %s\n",
                Thread.currentThread().getId(), Thread.currentThread().getName(), driver.toString());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("DEBUG: after method: close driver");
        DriverFactory.getInstance().removeDriver();
    }

    // step definitions
    @Given("I get to google")
    public void i_get_to_google() {
       driver.get("https://www.google.ca");
        Util.sleep(5);
    }
}
