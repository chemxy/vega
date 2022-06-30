package seng426.team14;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import seng426.team14.pages.IndexPage;
import seng426.team14.pages.LeadershipPage;
import seng426.team14.utils.DriverFactory;
import seng426.team14.utils.Util;

public class StepDefinitions {

    /* ------------------- declare properties ------------------*/
    protected WebDriver driver;
    protected IndexPage indexPage = new IndexPage();
    protected LeadershipPage leadershipPage = new LeadershipPage();

    /* --------------------------- before and after lifecycles ------------------------------*/
    @Before // run before each scenario.
    public void setUp() throws Exception {
        System.out.println("DEBUG: before method: init driver");
        driver = DriverFactory.getInstance().getDriver();
        System.out.printf("DEBUG: Current Thread ID - %d\nThread Name - %s\nCurrent Driver - %s\n",
                Thread.currentThread().getId(), Thread.currentThread().getName(), driver.toString());
        //inject instance of page objects
        indexPage.setDriver(driver);
        leadershipPage.setDriver(driver);

    }

    @After // run after each scenario, even when the step result is failed, undefined, pending, or skipped
    public void tearDown() throws Exception {
        System.out.println("DEBUG: after method: close driver");
        DriverFactory.getInstance().removeDriver();
    }

    /* --------------------------- step definitions ------------------------------*/
    @Given("I get to index page")
    public void iGetToIndexPage() {
        driver.get("https://localhost:3000");
    }

    @When("I click on the first slide button")
    public void iClickOnTheFirstSlideButton() {
        indexPage.clickOnSlideButton1();
    }


    @Then("I should see the first slide image")
    public void iShouldSeeTheFirstSlideImage() {
        Util.isWebElementVisible(this.driver, this.indexPage.slideImage1);
    }


}
