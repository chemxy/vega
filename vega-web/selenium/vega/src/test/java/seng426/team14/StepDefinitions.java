package seng426.team14;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.AcceptedW3CCapabilityKeys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import seng426.team14.pages.*;
import seng426.team14.utils.DriverFactory;
import seng426.team14.utils.Util;
import seng426.team14.utils.webActions;

public class StepDefinitions {

    /* ------------------- declare properties ------------------*/
    protected WebDriver driver;
    protected IndexPage indexPage = new IndexPage();
    protected NewsAndEventsPage newsAndEventsPage = new NewsAndEventsPage();
    protected LeadershipPage leadershipPage = new LeadershipPage();
    protected PlatformPage platformPage = new PlatformPage();
    protected AccountSignInPage accountSignInPage = new AccountSignInPage();

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
        platformPage.setDriver(driver);
        newsAndEventsPage.setDriver(driver);
        accountSignInPage.setDriver(driver);

    }

    @After // run after each scenario, even when the step result is failed, undefined, pending, or skipped
    public void tearDown() throws Exception {
        System.out.println("DEBUG: after method: close driver");
        DriverFactory.getInstance().removeDriver();
    }

    /* --------------------------- step definitions ------------------------------*/
    @Given("I get to index page")
    public void iGetToIndexPage() {
        driver.get("http://localhost:3000/");
    }

    @When("I click on the first slide button")
    public void iClickOnTheFirstSlideButton() {
        indexPage.clickOnSlideButton1();
    }


    @Then("I should see the first slide image")
    public void iShouldSeeTheFirstSlideImage() {
        Util.isWebElementVisible(this.driver, this.indexPage.slideImage1);
    }


    @Given("I get to platform page")
    public void iGetToPlatformPage() {
        driver.get("http://localhost:3000/platform");
    }

    @When("I am on the platform page")
    public void iAmOnThePlatformPage() {
        Util.verifyCurrentUrl("http://localhost:3000/platform");
    }

    @Then("I should see the navbar and the page content displayed")
    public void iShouldSeeTheNavbarAndThePageContentDisplayed() {
        platformPage.isContentDisplayed();
    }


    @Given("I get to news page")
    public void iGetToNewsPage() {
       driver.get("http://localhost:3000/news");
    }

    @When("I am on the news page")
    public void iAmOnTheNewsPage() {
        Util.verifyCurrentUrl("http://localhost:3000/news");
    }

    @And("There is a news post")
    public void thereIsANewsPost(){
        Util.isWebElementVisible(this.driver, this.newsAndEventsPage.newsContent1);
    }

    @Then("I should see the post")
    public void iShouldSeeThePost() {
        Util.isWebElementVisible(this.driver, this.newsAndEventsPage.newsContent1);
    }

    @When("I click on add news button")
    public void iClickOnAddNewsButton() {
        newsAndEventsPage.clickOnAddNewsButton();
    }

    @And("There is no news post on the page")
    public void thereIsNoNewsPostOnThePage() {
        newsAndEventsPage.deleteNewsPosts();
    }


    @And("I input the news content")
    public void iInputTheNewsContent() {
        newsAndEventsPage.inputNewsContent();
    }

    @Then("I should see the corresponding news on the news page")
    public void iShouldSeeTheCorrespondingNewsOnTheNewsPage() {
        newsAndEventsPage.verifyNewPost();
    }


    @And("I click on cancel button")
    public void iClickOnCancelButton() {
        newsAndEventsPage.clickOnCancel();
    }

    @Then("I should not see the post")
    public void iShouldNotSeeThePost() {
        newsAndEventsPage.verifyNoNewsPost();
    }


    @And("I am logged in as admin")
    public void iAmLoggedInAsAdmin() {
       accountSignInPage.loginAsAdmin();
    }


    @And("there is a delete button")
    public void thereIsADeleteButton() {
        newsAndEventsPage.isDeleteButtonDisplayed();
    }

    @When("I click on delete button")
    public void iClickOnDeleteButton() {
        newsAndEventsPage.clickOnDeleteButton();
    }


    @And("there is an edit button")
    public void thereIsAnEditButton() {
        newsAndEventsPage.isEditButtonDisplayed();
    }

    @When("I click on edit button")
    public void iClickOnEditButton() {
        newsAndEventsPage.clickOnEditButton();
    }

    @And("I navigate to news page")
    public void iNavigateToNewsPage() {
        newsAndEventsPage.clickOnNewsTab();
    }

    @And("I click on submit news button")
    public void iClickOnSubmitNewsButton() {
        newsAndEventsPage.clickOnSubmit();
    }
}
